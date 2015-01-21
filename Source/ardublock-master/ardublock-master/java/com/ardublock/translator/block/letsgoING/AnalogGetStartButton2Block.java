package com.ardublock.translator.block.letsgoING;
import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class AnalogGetStartButton2Block extends TranslatorBlock
{
	public AnalogGetStartButton2Block(Long blockId, Translator translator, String codePrefix,	String codeSuffix, String label)
	{
		super(blockId, translator, codePrefix, codeSuffix, label);
	}

	private final static String serialEventFunction = " AnalogButton Button3(3);\n";

	
	public String toCode() throws SocketNullException, SubroutineNotDeclaredException
	{
		
		 // Header hinzuf�gen
		translator.addHeaderFile("LGI_AnalogButton.h");
		
		
		// Deklarationen hinzuf�gen
		translator.addDefinitionCommand(serialEventFunction);

		String ret = "Button3.startButton();";
		

		return codePrefix + ret + codeSuffix;
	}
	
}