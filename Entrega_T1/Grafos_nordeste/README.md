# Grafos - Região Nordeste do Brasil

## 👥 Grupo C

### Integrantes

- José Eugênio — 2320466  
- Mateus Rocha Lessa — 2410456  
- Carlos Huan Celestino de Brito — 2320478  
- Lucas de Vasconcelos Barreira Carvalho — 2410424  

---

## Vídeo Explicativo

👉 *(adicione aqui o link do vídeo de até 2 minutos)*

---

## 📌 Sobre o Projeto

Este projeto foi desenvolvido para a disciplina de **Grafos**.

A proposta é modelar um grafo representando os estados da região Nordeste do Brasil, considerando suas fronteiras terrestres, e aplicar algoritmos de busca para análise de caminhos e conectividade.

---

## O que representa o grafo

Neste problema:

- **Vértices** → Estados do Nordeste  
- **Arestas** → Fronteiras terrestres entre os estados  

Ou seja, se dois estados fazem fronteira, existe uma aresta conectando eles no grafo.

---

## ⚙️ Estrutura do Projeto

A implementação foi feita em **Java**, utilizando lista de adjacência.

### Graph
Responsável por representar o grafo, armazenando:
- número de vértices  
- número de arestas  
- lista de adjacência (vizinhos de cada estado)  

### DepthFirstPaths (DFS)
- verifica conectividade  
- encontra caminhos no grafo  

### BreadthFirstPaths (BFS)
- encontra o menor caminho entre dois estados  

### Main
Responsável por:
- ler o arquivo do grafo  
- receber entrada do usuário  
- executar DFS e BFS  
- exibir os resultados  

---

## 📂 Arquivo de Entrada

```
dados/nordeste.txt
```

Formato:

```
9
13
0 1
0 5
...
```

- Primeira linha → número de vértices  
- Segunda linha → número de arestas  
- Demais linhas → conexões entre estados  

---

## ▶️ Como executar

### 1️⃣ Entrar na pasta

```
cd Grafos_nordeste
cd src
```

### 2️⃣ Compilar

```
javac *.java
```

### 3️⃣ Executar

```
java Main
```

---

## 💻 Funcionamento

O programa solicita:

- Estado inicial  
- Estado de destino  

E retorna:

- Se existe caminho  
- Caminho com DFS  
- Caminho com BFS  
- Estados alcançáveis  
- Ordem de visita DFS  
- Ordem de visita BFS  
