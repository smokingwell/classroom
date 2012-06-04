#include <stdio.h>
#include <regex.h>
#include <assert.h>
#include "../util/c_test.h"

int main(){

	{
		//test regerror
		regex_t preg;
		char *regex="[ab[d";
		char errbuf[256];
		int errcode;
		errcode = regcomp(&preg, regex, 0);
		if( errcode != 0){
			regerror(errcode, &preg, errbuf, sizeof(errbuf));
			printf("regerror: %s\n", errbuf);
		}
	}
	
	{
		//test regexec
		#define nmatch 5
		char *string="Tabs are 8 characters, and thus indentations are also 8 characters.\n";
		regex_t preg;
		char *regex="char[a-z]+";
		regmatch_t pmatch[nmatch];
		unsigned int i, len;
		memset(&preg, 0, sizeof(regex_t));
		if( regcomp(&preg, regex, REG_EXTENDED)==0)
		{
			while( string!=NULL && strlen(string) > 0 && regexec(&preg, string, nmatch, pmatch, 0) == 0 )
			{
				for( i=0; i < nmatch;  i++){
					if(pmatch[i].rm_so == -1 )continue;
					len = (pmatch[i].rm_eo - pmatch[i].rm_so);
					printf("i=%d, %.*s\n", i, len, (string+pmatch[i].rm_so));
					string = string+pmatch[i].rm_eo;
				}
			}
		regfree(&preg);
		}
	}

	{
		//test how to use () in regex
		char *string="Tabs are 8 characters, and thus indentations are also 8 characters.\n";
		regex_t preg;
		char *regex="([[:digit:]])[[:blank:]]char([a-z]+)";
		regmatch_t pmatch[nmatch];
		unsigned int i, len;
		memset(&preg, 0, sizeof(regex_t));
		int errcode;
		char errbuf[80];
		if( (errcode=regcomp(&preg, regex, REG_EXTENDED)) == 0)
		{
			while ( string!=NULL && strlen(string) > 0 && regexec(&preg, string, nmatch, pmatch, 0) == 0 )
			{
				for( i=0; i < nmatch;  i++){
					if(pmatch[i].rm_so == -1 )continue;
					len = (pmatch[i].rm_eo - pmatch[i].rm_so);
					assert(printf("start=%d, end=%d, length=%d\n", pmatch[i].rm_so, pmatch[i].rm_eo, len)!=0);
					printf("%.*s\n", len, (string+pmatch[i].rm_so));
				}
				string = string+pmatch[0].rm_eo;
			}
			regfree(&preg);
		}else{
			memset(errbuf, 0, 80);
			regerror(errcode, &preg, errbuf, sizeof(errbuf));
			printf("error message:%s\n", errbuf);
		}
	}

	return 0;
}

