# Projeto de Monitoramento de Hardware

### O projeto visa monitorar hardware de computadores de desenvolvedores, para ajudar e facilitar na busca da melhor experiência possível com o seu computador, o projeto consome outras APIs como: [Loooca](https://github.com/Britooo/looca-api.git) e [Slack](https://github.com/BandTec/integracao-slack.git) desenvolvidas e/ou adptadas pela [@SPTech](https://github.com/BandTec).

## Estrutura dos diretórios

### Para melhor organização e entendimento do processo de captura de dados e envio de alertas/mensagens, utilizamos o método MVC(Model-View-Controller) para a estruturação das class e Jframs(Telas). 

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
#### No diretório java fica todos os pacotes de class diividos pelo método MVC.
### Pacote Connection
#### Pacote com as class responsáveis pela conexão com o banco de dados (MYSql e Azure)
### Pacote Model
#### Pacote com as class responsáveis de encapsular os atributos e fazer as tratativas dos dados.
### Pacote View
#### Pacote 
