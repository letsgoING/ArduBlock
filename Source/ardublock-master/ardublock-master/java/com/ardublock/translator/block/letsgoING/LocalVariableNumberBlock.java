package com.ardublock.translator.block.letsgoING;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;


public class LocalVariableNumberBlock extends TranslatorBlock
{
	public LocalVariableNumberBlock(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
	{
		super(blockId, translator, codePrefix, codeSuffix, label);
	}

	@Override
	public String toCode()
	{
		
		String internalVariableName = translator.getNumberVariable(label);
		String declaration = "";
		
		if (internalVariableName == null )
		{
			internalVariableName = translator.buildVariableName(label);			
			declaration = "int ";						
			translator.addNumberVariable(label, internalVariableName);
		}
		return declaration + codePrefix + internalVariableName + codeSuffix;
	}
}
