package com.ardublock.translator.block;
import com.ardublock.translator.Translator;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class DriveDistanceWithSpeedBlock extends TranslatorBlock
{

  public DriveDistanceWithSpeedBlock (Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
  {
    super(blockId, translator, codePrefix, codeSuffix, label);
  }

  public String toCode() throws SocketNullException, SubroutineNotDeclaredException
  {
     String entfernung, geschwindigkeit, ret;
        
    // Wert von dem ersten Blockeingang auslesen
    TranslatorBlock translatorBlock = this.getRequiredTranslatorBlockAtSocket(0);
    entfernung = translatorBlock.toCode(); 

    translatorBlock = this.getRequiredTranslatorBlockAtSocket(1);
    geschwindigkeit = translatorBlock.toCode(); 
    
    // Header hinzufÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â¼gen
    translator.addHeaderFile("Fahren.h");
            
    // Deklarationen hinzufÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â¼gen
    translator.addDefinitionCommand("Fahren fahrzeug=Fahren(2, 3, 65, 10, 145);");
           
    // Code von der Mainfunktion
    ret = "fahrzeug.fahreGerichtet(" + entfernung + ", 0, " + geschwindigkeit + ");\n";
   
    return codePrefix + ret + codeSuffix;
  }
}
