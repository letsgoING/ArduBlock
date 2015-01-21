package com.ardublock.translator.block;

import com.ardublock.translator.Translator;

public class DigitalForwardBlock extends ConstBlock
{

	public DigitalForwardBlock(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
	{
		super(blockId, translator, codePrefix, codeSuffix, label);
		this.setCode("FORWARD");
	}
}
