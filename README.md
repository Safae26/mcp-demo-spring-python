# 🤖 Chatbot Agentique avec Spring AI et MCP

## 🎯 Objectif du Projet

Ce projet vise à construire un chatbot intelligent de nouvelle génération, capable d’interagir de manière contextuelle avec les utilisateurs. Il repose sur l’intégration du **protocole MCP (Multi-Agent Communication Protocol)**, facilitant la communication entre divers agents ou services, quel que soit leur langage d’implémentation : Java (Spring), Python ou NodeJS.

### Objectifs clés :
- Conception de l’architecture MCP
- Création de serveurs MCP en Java, Python et NodeJS
- Intégration d’un client intelligent avec Spring AI (Llama3.1, Claude, OpenAI)
- Communication inter-agent via SSE ou STDIO
- Application modulaire et agentique

---

## 🧱 Structure du Projet

Le projet `mcp-demo-spring-python` est organisé en trois modules principaux :

<img width="377" height="379" alt="1" src="https://github.com/user-attachments/assets/7b9e4248-ae3b-4420-afe5-9c595e864a27" />

### 🔹 `mcp-client` (Client Spring AI)

Client Java basé sur Spring Boot et Spring AI. Il gère l’interaction utilisateur, conserve le contexte de conversation et invoque dynamiquement les outils exposés via les serveurs MCP.

**Fonctionnalités :**
- Intégration LLMs (Llama3.1, Claude, OpenAI)
- Mémoire de conversation avec fenêtre glissante
- API REST via `AIRestController`
- Découverte automatique des outils MCP
  
<img width="376" height="416" alt="2" src="https://github.com/user-attachments/assets/be37eb99-416a-4b93-b369-c42afe37b482" />
---

### 🔹 `mcp-server` (Serveur MCP Java)

Serveur Java Spring Boot exposant des outils métiers via MCP. Il prend en charge la communication en temps réel avec SSE.

**Fonctionnalités :**
- Outils simulant une gestion d’entreprise (via `StockTools.java`)
- Communication SSE avec clients
- Intégration dynamique avec Spring AI


<img width="314" height="361" alt="3" src="https://github.com/user-attachments/assets/b473856e-e81e-4e3e-b6cb-a9b714e903ae" />

<img width="771" height="202" alt="8" src="https://github.com/user-attachments/assets/19b9d311-49fd-4178-ad9c-fe68e9d5416c" />
<img width="773" height="380" alt="7" src="https://github.com/user-attachments/assets/12a972e4-dce1-481e-b7e2-2bb27ed0449b" />
<img width="774" height="173" alt="6" src="https://github.com/user-attachments/assets/08963e96-72d5-4d71-87eb-f714012dad82" />
---

### 🔹 `python-mcp-server` (Serveur MCP Python)

Serveur Python simple exposant des outils via MCP et communiquant par STDIO avec le client.

**Fonctionnalités :**
- Implémentation de logique métier (`get_employee_info`)
- Communication via STDIO
- Intégration via fichier `mcp-servers.json`


<img width="317" height="54" alt="4" src="https://github.com/user-attachments/assets/dbb81ee6-2953-4939-96ad-7e7b2dc1ee32" />

---

## ⚙️ Technologies et Protocoles

- **Langages** : Java (Spring Boot), Python, NodeJS
- **IA** : Spring AI, Llama3.1, Claude, OpenAI
- **Communication** : MCP, SSE, STDIO
- **Outils de test** : Postman
- **Exécution locale LLM** : Ollama

---

## 🔍 Détails d’Implémentation

### 📁 `mcp-server` (Spring Boot)
- **`StockTools.java`** : expose des outils métiers fictifs (entreprises, actions…).
- **`McpServerApplication.java`** : configure et rend les outils accessibles via MCP.
- **`application.properties`** : définit les paramètres réseau, SSE et niveaux de log.

---

### 📁 `mcp-client` (Spring AI)
- **`AIAgent.java`** : agent conversationnel basé sur Spring AI.
- **`AIRestController.java`** : API REST pour interagir avec l’agent.
- **`McpClientApplication.java`** : appelle dynamiquement les outils MCP disponibles.
- **`application.properties`** : configuration du client et des LLMs.
- **`mcp-servers.json`** : gestion des serveurs NodeJS et Python déclenchés par ligne de commande.

<img width="773" height="530" alt="9" src="https://github.com/user-attachments/assets/d050a87a-26e7-44bd-9c45-540fbed861a4" />
<img width="770" height="446" alt="14" src="https://github.com/user-attachments/assets/0269eebe-0f8f-4b7e-a6cf-78814a055f26" />
<img width="769" height="171" alt="13" src="https://github.com/user-attachments/assets/7925e86e-5979-42e9-a5c7-2abd8dfe973f" />
<img width="773" height="378" alt="11" src="https://github.com/user-attachments/assets/b48a0c30-fca1-446f-96d4-eb2f91bddb19" />
<img width="773" height="348" alt="12" src="https://github.com/user-attachments/assets/a2842b5f-fa43-403b-a5bf-a8a2b5dc4d6c" />
<img width="770" height="296" alt="10" src="https://github.com/user-attachments/assets/7e69c1db-09ef-4607-b972-57e3671cc7a6" />

---

### 📁 `python-mcp-server`
- **`server.py`** : expose un outil métier via FastMCP.
- **Mode STDIO** : communication directe avec le client Spring AI.

<img width="771" height="300" alt="15" src="https://github.com/user-attachments/assets/71e15bb8-d6a1-4838-a30d-ebc136f9c517" />
---

## 🧪 Test avec Postman

- Liste des outils MCP disponibles
- Appels directs aux fonctions comme `getAllCompanies`, `getCompanyByName`
- Tests des connexions SSE
- Réception de messages temps réel via `/mcp/message`

---

## ⚠️ Problèmes Techniques Rencontrés

- Blocage lors du lancement du serveur Python (`server.py`)
- `ollama run llama3.1` reste bloqué sans sortie
- Hypothèse : contraintes matérielles ou environnementales

---


## ✅ Conclusion

Ce projet démontre la mise en œuvre d’un système intelligent interopérable entre plusieurs langages et plateformes grâce au protocole MCP. Il constitue une base solide pour le développement d’agents distribués, intelligents et modulaires.
