package com.ardublock.translator.block.letsgoING;
import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class DriveCurveDistanceBlock extends TranslatorBlock
{

  public DriveCurveDistanceBlock (Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
  {
    super(blockId, translator, codePrefix, codeSuffix, label);
  }

  public String toCode() throws SocketNullException, SubroutineNotDeclaredException
  {
    String direction, distance, speed, ret;
        
    // Wert von dem ersten Blockeingang auslesen
    TranslatorBlock translatorBlock = this.getRequiredTranslatorBlockAtSocket(0);
    distance = translatorBlock.toCode();
    
    translatorBlock = this.getRequiredTranslatorBlockAtSocket(1);
    direction = translatorBlock.toCode();
    
    translatorBlock = this.getRequiredTranslatorBlockAtSocket(2);
    speed = translatorBlock.toCode();
    
 //   translatorBlock = this.getRequiredTranslatorBlockAtSocket(3);
 //   directionFB = translatorBlock.toCode();
           
    // Header hinzufügen
    translator.addHeaderFile("letsgoING_Drive.h");
            
    // Deklarationen hinzufügen
	translator.addDefinitionCommand("Drive Rover;");
	
          
    // Code von der Mainfunktion
    ret = "Rover.driveCurveDistance(" + distance + "," +direction+ "," +speed + ");\n";
   
    return codePrefix + ret + codeSuffix;
  }
}
