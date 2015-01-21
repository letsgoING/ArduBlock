package com.ardublock.translator.block;
import com.ardublock.translator.Translator;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class NoDriveBlock extends TranslatorBlock
{

  public NoDriveBlock (Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
  {
    super(blockId, translator, codePrefix, codeSuffix, label);
  }

  public String toCode() throws SocketNullException, SubroutineNotDeclaredException
  {
    String ret;
                
    // Header hinzufÃƒÂ¼gen
    translator.addHeaderFile("Fahren.h");
            
    // Deklarationen hinzufÃƒÂ¼gen
    translator.addDefinitionCommand("Fahren fahrzeug=Fahren(2, 3, 65, 10, 145);");
            
           
    // Code von der Mainfunktion
    ret = "fahrzeug.fahreGerichtet(0, 0);\n";
   
    return codePrefix + ret + codeSuffix;
  }
}
