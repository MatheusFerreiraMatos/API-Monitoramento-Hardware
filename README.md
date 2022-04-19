# Projeto de Monitoramento de Hardware

### O projeto visa monitorar hardware de computadores de desenvolvedores, para ajudar e facilitar na busca da melhor experiência possível com o seu computador, o projeto consome outras APIs como: [Loooca](https://github.com/Britooo/looca-api.git) e [Slack](https://github.com/BandTec/integracao-slack.git) desenvolvidas e/ou adptadas pela [@SPTech](https://github.com/BandTec).

## Estrutura dos diretórios

### Para melhor organização e entendimento do processo de captura de dados e envio de alertas/mensagens, utilizamos o método MVC(Model-View-Controller) para a estruturação das class e Jframes(Telas). 

```
+---java
|   +---connection
|   |       Connection.java
|   |       TestandoConexao.java
|   |
|   +---controller
|   |       ControllerComputadores.java
|   |       ControllerLogin.java
|   |       ControllerMonitoramento.java
|   |       ControllerNotificacoes.java
|   |       ControllerProcessos.java
|   |       ControllerTabelas.java
|   |
|   +---model
|   |       Computadores.java
|   |       Contador.java
|   |       Cpu.java
|   |       Disco.java
|   |       InfoMaquina.java
|   |       Ram.java
|   |       Slack.java
|   |       Usuario.java
|   |
|   \---view
|           TelaCpu.form
|           TelaCpu.java
|           TelaDisco.form
|           TelaDisco.java
|           TelaLogin.form
|           TelaLogin.java
|           TelaPrincipal.form
|           TelaPrincipal.java
|           TelaRam.form
|           TelaRam.java
|
\---resources
        logo-casa.png
        logo-onhome-branco.png
        logo-onhome-preto.png
```

### Diretório Java
**No diretório java fica todos os pacotes de class dividos pelo método MVC.**
### Pacote Connection
**Pacote com as class responsáveis pela conexão com o banco de dados (MYSql e Azure)**
### Pacote Model
**Pacote com as class responsáveis de encapsular os atributos e fazer as tratativas dos dados.**
### Pacote View
**Pacote com as class e forms responsáveis por ilustrar o funcionamento do projeto em telas do Java Swing.**
### Pacote Controller
**Pacote com as class responsáveis pela lógica e execução da querys com o banco de dados.**
### Diretório Resources
**Diretório responsável por armazenar as imagens usadas nas Telas.**

## Instalação
#### O arquivo pom.xml já possui todas as dependencias necessarias para o uso da Aplicação.
```xml
    <dependencies>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-jdbc</artifactId>
            <version>5.0.5.RELEASE</version>
        </dependency>
        <dependency>
            <groupId>org.apache.commons</groupId>
            <artifactId>commons-dbcp2</artifactId>
            <version>2.5.0</version>
        </dependency>
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.28</version>
        </dependency>
        <dependency>
            <groupId>com.microsoft.sqlserver</groupId>
            <artifactId>mssql-jdbc</artifactId>
            <version>7.2.2.jre8</version>
        </dependency>
        <dependency>
            <groupId>com.github.britooo</groupId>
            <artifactId>looca-api</artifactId>
            <version>1.0.3</version>
        </dependency>
        <dependency>
            <groupId>org.json</groupId>
            <artifactId>json</artifactId>
            <version>20201115</version>
        </dependency>
    </dependencies>
```

**Instale pele linha de comando(Terminal) as dependências com o comando:**
```
$ mvn install
```

## Uso

### Antes de criarmos o arquivo .jar para o uso total da Aplicação, precisamos testar a conexão com o Banco de dados

**Na class Connection.java, configure o seu usuário e senha:**

```java
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/onhome"); //COLOQUE AQUI O LOCAL E O BANCO A SER USADO
        dataSource.setUsername("OnHome"); //COLOQUE AQUI O USUÁRIO
        dataSource.setPassword("adminonhome@"); // COLOQUE AQUI A SENHA DO USUÁRIO CITADO ACIMA
```

**Com a class de conexão configurada, vamos testar essa conexão.**
**Na class TestandoConexão.java temos um pequeno script de teste, onde criamos uma tabela, inserimos, mostramos e deletamos a mesma para o teste da conexão com o banco, execute essa class MAIN, esperamos o seguinte resultado:**

```
----------------------[ Testando Banco de Dados ]-----------------------
Criando tabela onHome...

Tabela onHome criada com sucesso!
------------------------------------------------------------------------
Inserindo dados na tabela onHome...

Dados inseridos na tabela onHome com sucesso!
------------------------------------------------------------------------
Listando dados da tabela onHome...

Dados da tabela onHome (comando SELECT): 

[{idUsuario=1, emailUser=teste@teste.com, senhaUser=teste123}]

Tudo ok!?

------------------------------------------------------------------------
Deletando tabela onHome...
Tabela excluida com sucesso!!! BANCO DE DADOS OK!
------------------------------------------------------------------------
Apliccation pronta para ser usada! OnHome
------------------------------------------------------------------------
```

**Com o teste do Banco de Dados já realizado, podemos colocar a Aplicação para rodar**

***Realize o Build do projeto para a compilação e geração do arquivo .jar para assim inicar a coleta de dados da máquina***
