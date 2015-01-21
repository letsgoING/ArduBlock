package com.ardublock.translator.block.letsgoING;
import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class LgiRGBBlock extends TranslatorBlock
{

  public LgiRGBBlock (Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
  {
    super(blockId, translator, codePrefix, codeSuffix, label);
  }

  public String toCode() throws SocketNullException, SubroutineNotDeclaredException
  {
    String red, green, blue, ret;
        
    // Wert von dem ersten Blockeingang auslesen
    TranslatorBlock translatorBlock = this.getRequiredTranslatorBlockAtSocket(0);
    red = translatorBlock.toCode();
    
    translatorBlock = this.getRequiredTranslatorBlockAtSocket(1);
    green = translatorBlock.toCode();
    
    translatorBlock = this.getRequiredTranslatorBlockAtSocket(2);
    blue = translatorBlock.toCode();
           
    // Header hinzufügen
    translator.addHeaderFile("RGBdriver.h");
            
    // Deklarationen hinzufügen
	translator.addDefinitionCommand("#define CLK 4 \n#define DIO 5 \nRGBdriver Driver(CLK,DIO);\n");
	
          
    // Code von der Mainfunktion
    ret = "Driver.begin();\nDriver.SetColor(" + red + "," + green + "," + blue + ");\nDriver.end();\n";
   
    return codePrefix + ret + codeSuffix;
  }
}
