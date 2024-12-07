![Badge em Desenvolvimento](http://img.shields.io/static/v1?label=STATUS&message=EM%20DESENVOLVIMENTO&color=GREEN&style=for-the-badge)
# 🌱 LEAFT – Solução Tecnológica para Acompanhamento Nutricional

## 🎓 PAC - Projeto de Aprendizagem Colaborativa Extensionista do Curso de Engenharia de Software da Católica de Santa Catarina campus Joinville

### ❓ O que é o PAC?

O Projeto LEAFT integra o **Programa de Aprendizagem Colaborativa Extensionista (PAC)**, uma iniciativa do curso de Engenharia de Software do Centro Universitário Católica de Santa Catarina. 

O PAC tem como objetivo:
- 🤝 **Aproximar os acadêmicos do mercado**, promovendo experiências reais de desenvolvimento de software com impacto social.
- 🚀 **Oferecer aos estudantes a oportunidade de aplicar os conhecimentos adquiridos em sala de aula**, enfrentando desafios técnicos.
- 🌍 **Desenvolver soluções tecnológicas que atendam às necessidades de comunidades, organizações ou profissionais específicos.**

---

### 📋 Justificativa do PAC Perante a Entidade Beneficiada

O projeto foi desenvolvido para atender às necessidades dos nutricionistas, com base nas demandas sugeridas pela Professora de Nutrição do Centro Universitário Católica de Santa Catarina Joinville, **Jaqueline Schroeder de Souza**.

🩺 **Problema identificado:**
- A profissional já utiliza ferramentas tecnológicas em seus atendimentos, mas identificou **a falta de uma solução mais adequada** que:
  - 💡 **Facilite o engajamento dos pacientes.**
  - 📊 **Simplifique a análise prática das informações alimentares pelos nutricionistas.**

🔍 Atualmente, o desafio não é apenas técnico, mas também prático:
- ❌ **Falta de ferramentas específicas** e de fácil uso que dificultam:
  - A análise detalhada dos dados pelos nutricionistas.
  - O registro consistente de refeições por parte dos pacientes.

✨ **Como o LEAFT resolve essas barreiras?**
- 🟢 Facilita o registro alimentar pelos pacientes através de uma interface intuitiva e prática.
- 🟢 Otimiza a análise dos dados pelos nutricionistas, oferecendo uma solução funcional.
- 🟢 Promove maior engajamento dos pacientes, contribuindo para melhores resultados no acompanhamento nutricional.

Ao preencher a lacuna tecnológica identificada, o LEAFT ajuda a fortalecer a relação entre profissionais e usuários, oferecendo uma experiência eficiente e conectada.

---

### 📱 Descrição do App

O **LEAFT** é um aplicativo mobile desenvolvido para facilitar o acompanhamento nutricional, conectando pacientes e nutricionistas de forma prática e eficiente.

#### 🔑 Funcionalidades principais:
- 📸 **Registro de refeições** com fotos e descrições detalhadas.
- 📊 **Acesso rápido e centralizado** às informações dos pacientes pelos nutricionistas.
- 💬 **Envio de feedback personalizado** diretamente pelo app.

#### 🌟 Diferenciais:
- 🧑‍🤝‍🧑 Diferentemente de outras ferramentas do mercado, que são técnicas e robustas, o LEAFT prioriza **a experiência do paciente**.
- 🎨 Com uma interface intuitiva e atraente, o app:
  - ✅ **Engaja usuários leigos**, tornando o processo de registro simples e agradável.
  - 📂 Oferece aos nutricionistas dados organizados para análises mais eficientes e personalizadas.

#### 📌 Por exemplo:
- Um paciente pode:
  - ⏱️ **Registrar uma refeição em poucos segundos**, enviando fotos e descrições diretamente pelo aplicativo.
- O nutricionista pode:
  - 📋 **Visualizar e analisar dados de forma organizada**, sem a necessidade de ferramentas complexas ou pouco acessíveis.

---

### 🎯 Objetivo Principal do LEAFT

O LEAFT tem como foco:
1. 🛠️ **Otimizar o trabalho do nutricionista.**
2. 📈 **Promover o engajamento ativo dos pacientes.**
3. 🌱 **Criar uma ponte tecnológica eficiente entre ambas as partes.**

Essa ferramenta combina:
- 🚀 **Inovação tecnológica.**
- 🩺 **Cuidado com a saúde.**
- 💡 **Compromisso com projetos de impacto positivo na sociedade.**

---

✨ O LEAFT reflete o compromisso do PAC em criar soluções tecnológicas práticas e relevantes, que fazem a diferença na vida das pessoas.

---

# 📱 **Requisitos para Preparar o Ambiente de Desenvolvimento**

## 🛠️ **1. Instalar o Android Studio**
- 🔗 Baixe a versão mais recente do Android Studio no site oficial: [Android Studio](https://developer.android.com/studio).
- 💾 Instale o Android Studio seguindo as instruções específicas para o seu sistema operacional (Windows, macOS ou Linux).

## ☕ **2. Configurar o Java Development Kit (JDK)**
- 📌 O Android Studio requer o JDK para compilar projetos Kotlin. A versão recomendada é o **JDK 11 ou superior**.
- **Passos para instalação:**
  - 🔗 Baixe o JDK: [Oracle JDK 11](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) ou [OpenJDK](https://adoptium.net/).
  - 🖥️ **Configuração no Sistema Operacional:**
    - **Windows:**
      1. 🛠️ Vá em **Painel de Controle > Sistema > Configurações Avançadas do Sistema > Variáveis de Ambiente**.
      2. ➕ Adicione uma variável de sistema chamada `JAVA_HOME` com o caminho do diretório de instalação do JDK.
      3. ➕ Adicione `;%JAVA_HOME%\bin` ao final da variável `Path`.
    - **Linux/macOS:**
      ```bash
      export JAVA_HOME=/caminho/para/o/jdk
      export PATH=$JAVA_HOME/bin:$PATH
      ```
      Coloque estas linhas no arquivo de configuração do terminal, como `.bashrc` ou `.zshrc`.

## ⚙️ **3. Instalar o Gradle**
- 📦 Gradle é usado como sistema de build para projetos Android.
- O Android Studio já inclui o Gradle, mas, para instalação global:
  - 🔗 Baixe o Gradle: [Gradle Releases](https://gradle.org/releases/).
  - 🛠️ Extraia o arquivo e configure o `GRADLE_HOME`:
    ```bash
    export GRADLE_HOME=/caminho/para/gradle
    export PATH=$GRADLE_HOME/bin:$PATH
    ```
  - ✅ Verifique a instalação:
    ```bash
    gradle -v
    ```

## 🖥️ **4. Configurar um Emulador no Android Studio**
- Abra o Android Studio e vá em **AVD Manager** (**Tools > Device Manager**).
- ➕ Clique em **Create Virtual Device**.
- 📱 Escolha o modelo do dispositivo (ex.: Pixel 6) e clique em **Next**.
- 📥 Escolha uma imagem de sistema (ex.: Android 13.0).
- 🏁 Conclua a configuração e inicie o emulador.

## 🔌 **5. Configurar um Smartphone Android**
- **Habilitar o modo desenvolvedor no smartphone:**
  1. ⚙️ Vá em **Configurações > Sobre o telefone**.
  2. ✨ Toque 7 vezes em **Número da versão** para ativar o modo desenvolvedor.
  3. 🛠️ No menu **Opções do Desenvolvedor**, habilite a **Depuração USB**.
- **Conectar o smartphone ao computador:**
  - 🔗 Conecte o dispositivo via cabo USB.
  - 📁 Certifique-se de que o modo de conexão está como **Transferência de Arquivos (MTP)**.
- **Verificar a conexão:**
  - 🖥️ No terminal, execute:
    ```bash
    adb devices
    ```
  - 📋 O dispositivo conectado deve aparecer na lista.

## 🔄 **6. Clonar o Repositório e Abrir o Projeto**
- **Clonar o repositório:**
  - 🖥️ No terminal, use:
    ```bash
    git clone https://github.com/leaft-app/leaft-app.git
    ```
- **Abrir no Android Studio:**
  - 🏗️ Abra o Android Studio e selecione **Open** para importar o projeto clonado.
  - 🔄 Certifique-se de que as dependências no arquivo `build.gradle` sejam sincronizadas automaticamente.

## 📥 **7. Sincronizar Dependências do Gradle**
- O Android Studio deve baixar todas as dependências automaticamente ao abrir o projeto. Caso contrário:
  - 🛠️ Clique em **Sync Now** na barra superior ou em **File > Sync Project with Gradle Files**.
  - 🌐 Certifique-se de que há conexão com a internet.

## ▶️ **8. Configurar o Dispositivo de Execução**
- **Rodar no emulador:**
  - Selecione o dispositivo virtual configurado no menu superior e clique em **Run** ▶️.
- **Rodar no smartphone real:**
  - Selecione o smartphone conectado na lista de dispositivos no menu superior.
  - Clique em **Run** ▶️.

---

# 🚀 **Testar e Rodar o APK**

## 🏗️ **1. Gerar o APK para instalação**
- No Android Studio, clique em **Build > Build Bundle(s)/APK(s) > Build APK(s)**.
- 📂 O arquivo APK será gerado na pasta `app/build/outputs/apk`.

## 📱 **2. Instalar o APK no Smartphone**
- Copie o APK para o dispositivo ou use o comando:
  ```bash
  adb install /caminho/para/o/apk

---

## 📱 **3. Abrir o Aplicativo no Dispositivo**

**Passo 1:** Certifique-se de que o dispositivo está conectado via cabo USB ao computador.
  - 🔌 Utilize um cabo USB funcional e, se possível, o original do dispositivo.
  - 🖥️ O modo de conexão deve estar configurado como **Transferência de Arquivos (MTP)**.
    
**Passo 2:** Após instalar o APK (com o comando `adb install` ou copiando manualmente o arquivo para o dispositivo):
  - 📂 Caso tenha copiado o APK manualmente, abra o **Gerenciador de Arquivos** no dispositivo e localize o APK copiado.
  - ➡️ Toque no arquivo para instalar. Se necessário, ative a permissão de instalação de fontes desconhecidas em **Configurações > Segurança > Permitir Instalação de Apps Desconhecidos**.

**Passo 3:** Após a instalação ser concluída:
  - 🌐 Desplugue o cabo USB do dispositivo para garantir a segurança dos dados.

- **Passo 4:** No dispositivo, localize o aplicativo instalado na tela inicial ou no menu de aplicativos.
  - 🔎 Procure pelo ícone com o nome **Leaft App**.
  - 🎉 Toque no ícone para abrir o aplicativo e verificar se ele está funcionando corretamente.

 ---

 ## 📸 Capturas de Tela do Aplicativo

### 1️⃣ **Tela Inicial**
![01_TELA_INICIAL](https://github.com/user-attachments/assets/5005b654-9586-4bbe-acb8-a562ee48afb3)

- ✨ A tela inicial do aplicativo permite que o usuário escolha se deseja entrar como **Nutricionista** ou **Cliente**.
- ➡️ Após escolher o perfil, o usuário é direcionado para a tela de login.

---

### 2️⃣ **Tela Home do Nutricionista**
![02_TELA_NUTRI_GERA_QR_CADASTRAR_PACIENTE](https://github.com/user-attachments/assets/1d50eb2d-9b5c-4714-bd3f-ecc296960b4b)

- 🏠 Esta é a tela inicial do profissional nutricionista, com uma visão geral das atividades de seus pacientes/clientes.
- 🟢 Inclui a funcionalidade de gerar um **Código QR**:
  - 🔗 O código QR permite que o cliente/paciente se cadastre diretamente com seu nutricionista através de uma chave única e intransferível.

---

### 3️⃣ **Relação de Pacientes do Nutricionista**
![06_TELA_NUTRI_RELACAO_PACIENTE](https://github.com/user-attachments/assets/99503e9b-7988-4151-8ee5-fb0dd4348790)

- 📋 Tela onde o nutricionista tem acesso à **lista completa de seus pacientes/clientes**.
- 🔍 Facilita a organização e o acompanhamento individual de cada paciente.

---

### 4️⃣ **Recuperação de Senha**
![03_TELA_COD_VERIFICACAO_PARA_ALTERAR_SENHA](https://github.com/user-attachments/assets/36e00aa4-a5b4-4742-a0e7-5fb6d6b13bb4)

- ❓ Caso um usuário esqueça sua senha:
  - 📧 Um código de verificação é enviado para o e-mail cadastrado.
  - 🔑 Após validar o código, o usuário pode criar uma **nova senha** para acesso.

---

### 5️⃣ **Tela de Cadastro do Cliente com QR Code**
![04_TELA_CLIENTE_LER_QR_GERADO_PELO_NUTRI](https://github.com/user-attachments/assets/44d3d564-03e6-425e-b52e-41525260ef5a)

- 👤 Tela onde o cliente pode se cadastrar ao escanear o **QR Code gerado pelo nutricionista**.
- 📷 Ao tocar em "Entrar", a câmera do dispositivo é ativada para realizar a leitura do código.

---

### 6️⃣ **Tela de Refeições do Cliente**
![05_TELA_REFEICOES_CLIENTE](https://github.com/user-attachments/assets/3bb61f88-cf88-4bc3-b971-1cfc4b14fb1c)

- 🍽️ Nesta tela, o cliente pode visualizar as refeições submetidas ao nutricionista.
- 📊 As informações organizadas ajudam no acompanhamento do plano alimentar proposto.

---

### 7️⃣ **Troca de Mensagens entre Paciente e Nutricionista**
![07_TELA_MENSAGEM_PACIENTE_NUTRI](https://github.com/user-attachments/assets/de2f8c7e-147d-4d01-8d69-ffbbd652e25f)

- 💬 Tela dedicada à comunicação direta entre o paciente/cliente e seu nutricionista.
- 📢 Permite uma troca de mensagens clara e rápida, otimizando o acompanhamento e tirando dúvidas em tempo real.

---

### 8️⃣ **Demonstração de Navegação**

Exemplo de navegação, versão 2.1.
https://github.com/user-attachments/assets/0a884b1d-a98a-4dbf-ae99-b53f812e162c

---

## 🌟 Resumo
As telas apresentadas mostram o fluxo de uso do **LEAFT**, destacando:
- A **facilidade de navegação** para nutricionistas e clientes.
- Funcionalidades que promovem a **conexão prática e eficiente** entre os dois perfis.
- Soluções tecnológicas voltadas ao **engajamento do paciente** e à **eficiência do profissional**.

---

### 🧑‍💻 **Equipe de Desenvolvimento**

O projeto **LEAFT** foi desenvolvido com dedicação e colaboração pela seguinte equipe:

- 👨‍💻 **Hélio Costa**
- 👨‍💻 **Isaac Graper**
- 👨‍💻 **Vinícius Zanatta**

