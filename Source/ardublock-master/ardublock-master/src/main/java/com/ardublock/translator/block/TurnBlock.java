package com.ardublock.translator.block;
import com.ardublock.translator.Translator;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class TurnBlock extends TranslatorBlock
{

  public TurnBlock (Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
  {
    super(blockId, translator, codePrefix, codeSuffix, label);
  }

  public String toCode() throws SocketNullException, SubroutineNotDeclaredException
  {
	    String speed, direction, ret;
        
	    // Wert von dem ersten Blockeingang auslesen
	    TranslatorBlock translatorBlock = this.getRequiredTranslatorBlockAtSocket(0);
	    speed = translatorBlock.toCode();
	    
	    translatorBlock = this.getRequiredTranslatorBlockAtSocket(1);
	    direction = translatorBlock.toCode();
	    
	           
	    // Header hinzufügen
	    translator.addHeaderFile("letsgoING_Drive.h");
	            
	    // Deklarationen hinzufügen
		translator.addDefinitionCommand("Drive Rover;");
		
	          
	    // Code von der Mainfunktion
		ret = "Rover.turn(" +speed + "," +direction + ");\n";
		
	   
	    return codePrefix + ret + codeSuffix;
	  }
	}
