package com.ardublock.translator.block.letsgoING;
import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class AndroidRemoteBlock1Mon extends TranslatorBlock
{
	public AndroidRemoteBlock1Mon(Long blockId, Translator translator, String codePrefix,	String codeSuffix, String label)
	{
		super(blockId, translator, codePrefix, codeSuffix, label);
	}


	private final static String serialEventFunction = " Ardudroid Remote;\n";
	
	public String toCode() throws SocketNullException, SubroutineNotDeclaredException
	{
		
		
		 // Header hinzufügen
		translator.addHeaderFile("letsgoING_Ardudroid.h");
		
		// Deklarationen hinzufügen
		translator.addDefinitionCommand(serialEventFunction);
		
		// setup hinzufügen
	
		
		// translator.addSetupCommand("Remote.BTbee_begin(9600);");
		translator.addSetupCommand("Remote.BTserial_begin();");
		
		// loop hinzufügen
		String ret = "";
			return codePrefix + ret + codeSuffix;
	}
	
}