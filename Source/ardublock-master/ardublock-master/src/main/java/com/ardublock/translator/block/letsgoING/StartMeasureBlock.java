package com.ardublock.translator.block.letsgoING;
import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class StartMeasureBlock extends TranslatorBlock
{

  public StartMeasureBlock (Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
  {
    super(blockId, translator, codePrefix, codeSuffix, label);
  }

  public String toCode() throws SocketNullException, SubroutineNotDeclaredException
  {
    String ret;
        
    // Wert von dem ersten Blockeingang auslesen

    

           
    // Header hinzufügen
    translator.addHeaderFile("letsgoING_Drive.h");
            
    // Deklarationen hinzufügen
	translator.addDefinitionCommand("Drive Rover;");
	
          
    // Code von der Mainfunktion
	ret = "Rover.startMeasure();\n";
	
   
    return codePrefix + ret + codeSuffix;
  }
}
