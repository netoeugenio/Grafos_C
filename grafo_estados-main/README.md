# 🌎 Análise de Fronteiras do Nordeste com Grafos

## 👥 Integrantes do Grupo C

- José Eugênio — 2320466  
- Mateus Rocha Lessa — 2410456  
- Carlos Huan Celestino de Brito — 2320478  
- Lucas de Vasconcelos Barreira Carvalho — 2410424  

🎥 **Vídeo explicativo do projeto:**  
https://youtu.be/_Ywi1G5GiQ4

---

## 📌 Descrição do Projeto

Este projeto foi desenvolvido para a disciplina de **Grafos**.

O objetivo é modelar um grafo onde:

- **Vértices** representam os estados da região Nordeste do Brasil  
- **Arestas** representam as fronteiras terrestres entre os estados  

A partir disso, aplicamos:

- **DFS (Depth-First Search)** → Busca em profundidade  
- **BFS (Breadth-First Search)** → Busca em largura  

Para analisar conectividade, caminhos e ordem de visita.

---

##  O que o programa responde

Dado um estado de origem `X` e destino `Y`, o programa responde:

- Se é possível chegar de `X` até `Y`
- Caminho encontrado pela **DFS**
- Caminho encontrado pela **BFS**
- Estados alcançáveis a partir de `X`
- Ordem de visita da **DFS**
- Ordem de visita da **BFS**

---




---

## ⚙️ Explicação das Classes

### 🔹 Bag
Estrutura de dados usada para armazenar os vizinhos de cada vértice.  
Baseada no padrão do **algs4**, funciona como uma lista encadeada.

---

### 🔹 Graph
Representa o grafo usando **lista de adjacência**.  
Responsável por:
- armazenar vértices e arestas  
- conectar estados (fronteiras)  

---

### 🔹 DepthFirstPaths (DFS)
Implementa a **busca em profundidade**:
- Explora o grafo indo o mais fundo possível  
- Encontra caminhos  
- Guarda a ordem de visita  

---

### 🔹 BreadthFirstPaths (BFS)
Implementa a **busca em largura**:
- Explora por níveis  
- Encontra o menor caminho (em número de arestas)  
- Registra a ordem de visita  

---

### 🔹 Main
Classe principal do programa:
- Lê o grafo do arquivo  
- Recebe entrada do usuário  
- Executa DFS e BFS  
- Exibe todos os resultados  

 

---

##  Como rodar o projeto

### 1️⃣ Clonar o repositório

```bash
git clone https://github.com/netoeugenio/Grafos_C.git
2️⃣ Entrar na pasta do projeto
cd Grafos_C
cd grafo_estados-main
3️⃣ Entrar na pasta do código
cd src
4️⃣ Compilar os arquivos Java
javac *.java
5️⃣ Executar o programa
java Main
💻 Exemplo de uso
Digite a sigla do estado de origem: CE
Digite a sigla do estado de destino: BA

Saída esperada:

Caminho DFS
Caminho BFS
Estados alcançáveis
Ordem de visita
