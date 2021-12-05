# 1. Introdução
Nessa aula você irá criar uma aplicação que usa e Intents para navegar entre activitys.

## 1.1 Pré-requisitos

Para essa aula é necessario que o aluno possua:

* Um computador com Android Studio Arctic Fox | 2020.3.1 Patch 2
* Um AVD PIXEL 2 XL API 30 com Android 11 ou Dispositivo compativel
* SDK ANDROID 11 API LEVEL 30

## 1.2. Conhecimentos Prévios.
Para essa aula você precisa:

* Conhecer lógica de programação
* Conhecer a sintaxe Kotlin
* Conhecer comando básicos do Git/Github
* Conhecer e manipular classes e métodos em Kotlin
* Conhecer e manipular recursos XML para criação de uma Activity

## 1.3. O que você aprenderá
Ao fim dessa aula você será capaz de:

* usar uma intent explícita para navegar até uma atividade específica;
* usar uma intent inplícita para navegar até um conteúdo de outra aplicação


#2. Conhecendo o projeto
Nesse projeto você ira usar um projeto previamente desenvolvido para por em prática seus conhecimentos.
Algumas dessas telas já estão implementadas. Sua tarefa é usar intents para que o projeto inteiro funcione, sem precisar criar tudo do zero.

![Telas do projeto](https://github.com/ramonsl/uso_de_intents/blob/master/Captura%20de%20Tela%202021-12-05%20a%CC%80s%2013.57.00.png?raw=true)

## 2.1. Baixando o projeto

Essa aula oferece um código inicial para que você ponha em prática o que está sendo passado. Primeiramente sera necessario baixar o código no git.

Para isso você irá clonar o repositório:
> https://github.com/ramonsl/uso_de_intents.git

1. Inicie o Android Studio
2. Na janela Welcome to Android Studio, clique em "*More Actions*" e ***Get From Version Control***.![Android Studio](https://github.com/ramonsl/Conversor/blob/master/Captura%20de%20Tela%202021-12-05%20a%CC%80s%2014.11.54.png?raw=true)
3. Infome a url do repositório. *https://github.com/ramonsl/uso_de_intents.git*
4. Clique em clone.
5. Aguarde o Android Studio abrir o projeto.
6. Clique no botão Run para criar e executar o app. Confira se ele é compilado da forma esperada.
7.  Procure os arquivos do projeto na janela de ferramentas Project para ver como o app está configurado.

## 2.2.Visão do Projeto
Se tudo funcionou conforme esperado,você tera a seguinte estrutura de arquivos.
![Visão do Projeto](https://github.com/ramonsl/Conversor/blob/master/Captura%20de%20Tela%202021-12-05%20a%CC%80s%2014.21.23.png?raw=true)

Para concluir essa aula, você irá trabalhar com os seguintes arquivos:

1. `MainActivity` Nessa activity temos a tela inicial com informações do hotel e dois botões "Veja nossas fotos" e "Entre em contato", é nessa tela que você manipulara **Intents explícitas** gerenciando a chamadas de telas do seu próprio app. 
2. `ContatoActivity` Nessa activity você irá trabalhar com **Intents implicitas**. Nessa tela temos três botões, cada um deles chamará uma intent especifica.

# 3. Introdução as Intents

Com o projeto já configurado, vamos falar sobre Intents.
Uma *intent* é um objeto que representa alguma ação para ser realizada. Geralmente seu uso é iniciar uma atividade. No Android, possuímos dois tipos:**Implícitas** e **Explícitas**.

Uma intent explícita é especifica, onde você sabe qual a atividade será iniciada, geralmente é uma tela do próprio app.

Uma intent implícita, possuí um comportamento mais genérico. Pois nessas intents, informamos um tipo de ação, como enviar um email ou fazer uma chamada.

A intents explícitas são na sua maioria ações ou apresentações de tela no app atual e ele é responsável por todo o processo. Normalmente, você usa intents implícitas para realizar ações que envolvem outros apps e dependem do sistema para determinar o resultado final.  Neste projeto você usará os dois tipos de intents.
 
> As intents além de iniciar uma atividade, podem por exemplo iniciar um serviço ou fornecer uma transmissão.


## 3.1. Configurando uma Intent Explícita.

Vamos começar com uma intent Explícita, na `MainActivity`.
Como você pode observar o código:

![Trecho de código](https://github.com/ramonsl/Conversor/blob/master/carbon%20(22).png?raw=true)

Nesse trecho temos ao clicar no botão ***btnContato*** o evento `setOnClickListener` irá criar um objeto intent, utilizando o construtor padrão do objeto, no qual você irá passar o contexto da aplicação e para qual activity você quer redirecionar, nesse caso ContatoActivity. Ao fim é necessario chamar essa intent, com o métodos  `startActivity`.
Esse código irá fazer com que uma nova activity seja apresentada.

Você pode saber mais sobre intents Explícita na documentação do Google Developers [Link](https://developer.android.com/guide/components/intents-filters#ExampleExplicit)


## 3.2. Configurando uma Intent Implícita.
Na maioria das vezes vamos trabalhar com intents explícitas, mas há situações que podemos não saber qual atividade o app irá acessar. Por exemplo quando queremos redirecionar o usuario do seu app para um site por meio de uma URL, não podemos afirmar que todos estão usando o Google Chrome com navedador padrão, pois os usuários podem optar por algum outro navegador. Tambem não podemos garantir quais app o usuário possuem instalado.
Esse é um exemplo de quando usar uma intent implícita. O app fornece informações ao sistema sobre qual ação deve ser tomada, e o sistema descobre o que fazer com essa ação, solicitando ao usuário mais informações conforme sua necessidade.

Na `ContatoActivity` vamos fazer o uso de duas intents implicitas, uma para abrir uma pagina na internet e outra para realizar uma chamada telefonica.  É importante que você saíba que esse são dois exemplos de intents implícitas, mas que há muitas outras. Você pode conhecer elas acessando a [documentação do google.](https://developer.android.com/guide/components/intents-common).
Cada tipo de intent possui dados, parametros e permissões que podem ser consultadas nessa documentação.

### 3.2.1. Iniciar uma chamada telefônica
Vamos iniciar com uma intent bem comum, que é realizar uma chamada telefonica.
Na nossa activity, possuímos um botão que informa o telefone do hotel e faz todo o sentido ao usuário que ao clicar nele possamos abrir o discador padrão do Android.
Para isso, primeiramente é necessario verificar na documentação quais as permissões ou parametros essa intent precisa. No caso dessa, precisamos de uma permissão, que deve ser adicionada ao `AndroidManifest.xml`

![Permissão no AndroidManifest](https://github.com/ramonsl/Conversor/blob/master/carbon%20(23).png?raw=true)

Dada essa permissão, devemos criar essa intenção. Neste exemplo optou-se em criar um método para isso, conforme o código abaixo.

![Método para discar](https://github.com/ramonsl/Conversor/blob/master/carbon%20(24).png?raw=true)

Esse método irá usar a `Intent.ACTION_DIAL` que é resposável por abrir o discador padrão do celular. Observer que estamos passado para intent um objeto data, que é a normatização do telefone a ser discado. Por fim temos a chamada dessa intent por meio do `startActivity(intent)`.

No método `btnFone.setOnClickListener` temos apenas a invoção do método, passando como parâmetro uma string do telefone a ser discado.


![Método](https://github.com/ramonsl/Conversor/blob/master/carbon%20(26).png?raw=true) 
 
###  3.2.2. Carregar um URL da Web

Outra intent presente nessa Activity é a que carrega uma URL na WEB. Essa intent não possui nenhuma permissão necessaria, entretanto ela possui filtros de intents que devem ser adicionados no AndroidManifest.xml.

![AndroidManifest](https://github.com/ramonsl/Conversor/blob/master/carbon%20(21).png?raw=true)

> Os filtros de intents ajudam que o Android possa fornececer uma melhor usabilidade e funcionalidade aos usuários. Para saber mais sobre os filtros, sugiro a leitura [Correspondência de intents](https://developer.android.com/guide/components/intents-filters#imatch)

Novamente vamos fazer uso de um método para criar essa intent.

![Método](https://github.com/ramonsl/Conversor/blob/master/carbon%20(20).png?raw=true)

Assim como para chamar o discador, precisamos chamar uma intenção de `Intent.ACTION_VIEW` para que nosso app encaminhe para o navegador padrão e inicie a intent com a URL informada por parâmetro 

# 4. Conclusão
Ao fim desta aula você deve saber que:

* As intents explícitas são usadas para navegar até atividades do seu app.
* As intents implícitas correspondem a ações específicas (como abrir um email ou abrir a camerta) e deixam que o sistema determine como realizar tal intent.

**Para realizar uma intent:**

1. Acessar uma referência do contexto.
2. Criar o objeto Intent, fornecendo uma atividade ou um tipo de intent, conforme se ela for explícita ou implícita.
3. Verificar se há necessidade de permissões, filtros ou dados a serem passados.
4. Chamar a startActivity() passando por parâmetro o objeto intent.

# 5. Mãos na massa!
Agora que você já conhece as intents, chegou a sua vez de exercitar para isso faça.
1. Crie uma intent em `ContatoActivity`  para enviar um email ao hotel.
2. Crie uma intent e uma Activity para exibir ao menos uma fotto do hotel.

## 5.1. Já terminou?
Você já concluiu a atividade? Então crie uma nova atividade para abrir o mapa até o endereço do hotel.

## 5.2 Correção dos exercicios.
Acessando a branch `ManoNaMassa` do repositório, você terá a correção do item 5. Você pode clicar diretamente no link [Correção Mão na Massa.](https://github.com/ramonsl/uso_de_intents/tree/MaoNaMassa)

Acessando a branch `ExtraMaps` do repositório, você terá a correção do item 5.1 Você pode clicar diretamente no link [Correção do Maps](https://github.com/ramonsl/uso_de_intents/tree/ExtraMaps)







