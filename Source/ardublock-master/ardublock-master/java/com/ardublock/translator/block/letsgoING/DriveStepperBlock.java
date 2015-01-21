package com.ardublock.translator.block.letsgoING;
import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class DriveStepperBlock extends TranslatorBlock
{

  public DriveStepperBlock (Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
  {
    super(blockId, translator, codePrefix, codeSuffix, label);
  }

  public String toCode() throws SocketNullException, SubroutineNotDeclaredException
  {
    String steps, speed, stepdirection, mNumber, stepsPrev, ret;
        
    // Wert von dem ersten Blockeingang auslesen
    TranslatorBlock translatorBlock = this.getRequiredTranslatorBlockAtSocket(0);
    steps = translatorBlock.toCode();
    
    translatorBlock = this.getRequiredTranslatorBlockAtSocket(3);
    speed = translatorBlock.toCode();
    
    translatorBlock = this.getRequiredTranslatorBlockAtSocket(4);
    stepdirection = translatorBlock.toCode();
    
    translatorBlock = this.getRequiredTranslatorBlockAtSocket(1);
    mNumber = translatorBlock.toCode();
    
    translatorBlock = this.getRequiredTranslatorBlockAtSocket(2);
    stepsPrev = translatorBlock.toCode();
           
    // Header hinzufügen
    translator.addHeaderFile("AFMotor.h");
      
    // Deklarationen hinzufügen
	translator.addDefinitionCommand("AF_Stepper motor(" + stepsPrev + "," + mNumber + ");");
	
  // Setup Code hinzufügen
  // translator.addSetupCommand("LEDBar.setMapLow(" + mapLow + ");");
  // translator.addSetupCommand("LEDBar.setMapHigh(" + mapHigh + ");");
	
          
    // Code von der Mainfunktion

	ret = "motor.setSpeed(" + speed +");\n" + "motor.step (" + steps + "," + stepdirection + ", SINGLE);\n" ;
   
    return codePrefix + ret + codeSuffix;
  }
}