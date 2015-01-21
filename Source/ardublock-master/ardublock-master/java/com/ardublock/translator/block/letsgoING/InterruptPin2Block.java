package com.ardublock.translator.block.letsgoING;
import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class InterruptPin2Block extends TranslatorBlock
{

	public InterruptPin2Block(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
	{
		super(blockId, translator, codePrefix, codeSuffix, label);
	}

	@Override
	public String toCode() throws SocketNullException, SubroutineNotDeclaredException
	{
		String interruptName = label.trim();
		if (!translator.containFunctionName(interruptName))
		{
			throw new SubroutineNotDeclaredException(blockId);
		}
		String ret = "";
		translator.addSetupCommand("attachInterrupt(0," +interruptName + ",CHANGE);\n");
//		return interruptName + "();\n";
		return ret;
	}

}