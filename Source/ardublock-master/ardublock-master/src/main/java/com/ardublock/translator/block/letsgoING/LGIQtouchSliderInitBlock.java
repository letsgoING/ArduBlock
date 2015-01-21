package com.ardublock.translator.block.letsgoING;
import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class LGIQtouchSliderInitBlock extends TranslatorBlock
{
	  public LGIQtouchSliderInitBlock (Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
	  {
	    super(blockId, translator, codePrefix, codeSuffix, label);
	  }

	  public String toCode() throws SocketNullException, SubroutineNotDeclaredException
	  {
	    String pin1, pin2, pin3, ret;
	        
	    // Wert von dem ersten Blockeingang auslesen
	    TranslatorBlock translatorBlock = this.getRequiredTranslatorBlockAtSocket(0);
	    pin1 = translatorBlock.toCode();
	    
	    translatorBlock = this.getRequiredTranslatorBlockAtSocket(1);
	    pin2 = translatorBlock.toCode();
	    
	    translatorBlock = this.getRequiredTranslatorBlockAtSocket(2);
	    pin3 = translatorBlock.toCode();
	    
	           
	    // Header hinzufuegen
	    translator.addHeaderFile("LGI_QTouch.h");
	            
	    // Deklarationen hinzufuegen
		translator.addDefinitionCommand("QTouchSlider Slider(" + pin1 + "," + pin2+ "," + pin3 +");\n");
		
		
		// setup hinzufuegen
		 translator.addSetupCommand("Slider.init();");

		
	          
	    // Code von der Mainfunktion
		// loop hinzufuegen
		ret = "";
			return codePrefix + ret + codeSuffix;
	  }
	}
