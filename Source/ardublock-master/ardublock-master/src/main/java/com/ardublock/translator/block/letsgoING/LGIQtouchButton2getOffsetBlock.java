package com.ardublock.translator.block.letsgoING;
import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class LGIQtouchButton2getOffsetBlock extends TranslatorBlock
{
	public LGIQtouchButton2getOffsetBlock(Long blockId, Translator translator, String codePrefix,	String codeSuffix, String label)
	{
		super(blockId, translator, codePrefix, codeSuffix, label);
	}


	
	public String toCode() throws SocketNullException, SubroutineNotDeclaredException
	{
		
		 // Header hinzufuegen
		translator.addHeaderFile("LGI_QTouch.h");
		
		
		// Deklarationen hinzuf�gen
		//translator.addDefinitionCommand(serialEventFunction);

		String ret = "Button2.getOffset()";
		

		return codePrefix + ret + codeSuffix;
	}
	
}