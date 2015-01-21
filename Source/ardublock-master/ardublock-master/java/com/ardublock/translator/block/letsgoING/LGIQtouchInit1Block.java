package com.ardublock.translator.block.letsgoING;
import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class LGIQtouchInit1Block extends TranslatorBlock
{
	  public LGIQtouchInit1Block (Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
	  {
	    super(blockId, translator, codePrefix, codeSuffix, label);
	  }

	  public String toCode() throws SocketNullException, SubroutineNotDeclaredException
	  {
	    String pin1, pin2, ret;
	        
	    // Wert von dem ersten Blockeingang auslesen
	    TranslatorBlock translatorBlock = this.getRequiredTranslatorBlockAtSocket(0);
	    pin1 = translatorBlock.toCode();
	    
	    translatorBlock = this.getRequiredTranslatorBlockAtSocket(1);
	    pin2 = translatorBlock.toCode();
	    
	           
	    // Header hinzufuegen
	    translator.addHeaderFile("LGI_QTouch.h");
	            
	    // Deklarationen hinzufuegen
		translator.addDefinitionCommand("QTouchButton Button1(" + pin1 + "," + pin2 +");\n");
		
		
		// setup hinzufuegen
		 translator.addSetupCommand("Button1.init();");

		
	          
	    // Code von der Mainfunktion
		// loop hinzufuegen
		ret = "";
			return codePrefix + ret + codeSuffix;
	  }
	}
