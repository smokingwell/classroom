package mytools.daomaker;

public interface IWorker {

	void create(String ddl_filepath, String output_directory);
	void create(String ddl_filepath, String output_directory,Translator translator);
	//void loadTranslator(Translator translator);

}
