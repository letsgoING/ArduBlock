package com.ardublock.translator.block.letsgoING;
import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class LedBarBlock extends TranslatorBlock
{

  public LedBarBlock (Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
  {
    super(blockId, translator, codePrefix, codeSuffix, label);
  }

  public String toCode() throws SocketNullException, SubroutineNotDeclaredException
  {
    String mapLow, mapHigh, wert, ret, pin1, pin2;
        
    // Wert von dem ersten Blockeingang auslesen
    TranslatorBlock translatorBlock = this.getRequiredTranslatorBlockAtSocket(0);
    pin1 = translatorBlock.toCode();
    
    translatorBlock = this.getRequiredTranslatorBlockAtSocket(1);
    pin2 = translatorBlock.toCode();
    
    translatorBlock = this.getRequiredTranslatorBlockAtSocket(3);
    mapLow = translatorBlock.toCode();
                
    translatorBlock = this.getRequiredTranslatorBlockAtSocket(4);
    mapHigh = translatorBlock.toCode();
    
    translatorBlock = this.getRequiredTranslatorBlockAtSocket(2);
    wert = translatorBlock.toCode();
    
    // Header hinzufügen
    translator.addHeaderFile("letsgoING_LEDBar.h");
            
    // Deklarationen hinzufügen
    translator.addDefinitionCommand("LEDBar LEDBar(" + pin1 + ", " + pin2 + ");");
            
    // Setup Code hinzufügen
  //  translator.addSetupCommand("LEDBar.setMapLow(" + mapLow + ");");
    //translator.addSetupCommand("LEDBar.setMapHigh(" + mapHigh + ");");
   
            
    // Code von der Mainfunktion
    ret = "LEDBar.setMapLow(" + mapLow + ");\n"+"LEDBar.setMapHigh(" + mapHigh + ");\n"+"LEDBar.analogToStack(" + wert + ", 0);\n";
    //ret = "LEDBar.analogToStack(" + wert + ", 0);\n";
   
    return codePrefix + ret + codeSuffix;
  }
}
