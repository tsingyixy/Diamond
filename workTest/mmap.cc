#include <iostream>
#include <cstdio>
#include <cstdlib>
#include <sys/mman.h>
#include <fcntl.h>
#include <sys/stat.h>
#include <sys/types.h>
using namespace std;
int main(int argc,char** argv)
{
    int fd;
    char *pmap;
    fd = open(argv[1],O_CREAT|O_RDWR|O_TRUNC,00777);
    lseek(fd,sizeof(char)*11-1,SEEK_SET);
    write(fd," ",1);
    pmap = (char*)mmap(NULL,sizeof(char)*11,PROT_READ|PROT_WRITE,MAP_SHARED,fd,0);
    close(fd);
    for(int i = 0 ; i < 11 ; i++)
        printf("%c\n",pmap[i]);
    munmap(pmap,sizeof(char)*11);
    cout<<"helloworld"<<endl;
    return 0;
}
