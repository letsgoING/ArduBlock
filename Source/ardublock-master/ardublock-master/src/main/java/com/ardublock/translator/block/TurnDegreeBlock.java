package com.ardublock.translator.block;
import com.ardublock.translator.Translator;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class TurnDegreeBlock extends TranslatorBlock
{

  public TurnDegreeBlock (Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
  {
    super(blockId, translator, codePrefix, codeSuffix, label);
  }

  public String toCode() throws SocketNullException, SubroutineNotDeclaredException
  {
    String grad, ret;
        
    // Wert von dem ersten Blockeingang auslesen
    TranslatorBlock translatorBlock = this.getRequiredTranslatorBlockAtSocket(0);
    grad = translatorBlock.toCode();
                
    // Header hinzufÃ¼gen
    translator.addHeaderFile("Fahren.h");
            
    // Deklarationen hinzufÃ¼gen
    translator.addDefinitionCommand("Fahren fahrzeug=Fahren(2, 3, 65, 10, 145);");
            
   
    // Code von der Mainfunktion
    ret = "fahrzeug.dreheGrad(" + grad + ");\n";
   
    return codePrefix + ret + codeSuffix;
  }
}
