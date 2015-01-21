package com.ardublock.translator.block;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class ReadBluetoothBlock extends TranslatorBlock
{
	public ReadBluetoothBlock(Long blockId, Translator translator, String codePrefix,	String codeSuffix, String label)
	{
		super(blockId, translator, codePrefix, codeSuffix, label);
	}


	
	public String toCode() throws SocketNullException, SubroutineNotDeclaredException
	{
	
		
		// loop hinzufügen
		String ret = "Remote.readBluetooth();\n";
			return codePrefix + ret + codeSuffix;
	}
	
}