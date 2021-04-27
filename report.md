
<div align="center">
    <h1> Meta-learning: Learning to Learn from Few Examples </h1>
 </div>




---
    
|Executor | X
|:-------|:-----
|Contributor | Y 
|Project | Z
|Nature | Experiment-level
|Goal| A
|Deadline| (for Production) B
|Timeline| C
|Version history| 08/07 - 12/07 <br> Meta-learning and Few-shot learning <br><br> 15/07 - 19/07 <br> metric-based approach on Omniglot dataset <br> Start modifying MAML and metric-based approach 
|Key progress| 22/07 - 26/07 <br> Continue with the implementation of MAML and metric-based approach for text classification

---
#### 1. [Problem](#problem)
#### 2. [Solutions](#solutions)
#### 3. [Experiment](#experiment)
#### 4. [Comment](#comment)  
####  [Q&A](#qna)  
---
## <a id="problem">1. Problem</a>
### **1.1 Key words**

<a id="finn17">[1]</a> Chelsea Finn, Pieter Abbeel, Sergey Levine. _Model-Agnostic Meta-Learning for Fast Adaptation of Deep Networks_. In Proceedings of the 34th International Conference on Machine Learning, Sydney, Australia, PMLR 70, 2017.

<a id="vinyals16">[2]</a> Oriol Vinyals, Charles Blundell, Timothy Lillicrap, Koray Kavukcuoglu, Daan Wierstra. _Matching Networks for One Shot Learning_. In Proceedings of the 30th Conference on Neural Information Processing Systems (NIPS 2016), Barcelona, Spain.

<a id="jamal19">[11]</a> Muhammad Abdullah Jamal, Guo-Jun Qi, and Mubarak Shah. _Task-Agnostic Meta-Learning for Few-shot Learning_. The IEEE Conference on Computer Vision and Pattern Recognition (CVPR), 2019, pp. 11719-11727.

### **1.2 Δ Input**   

---
## <a id="solutions">2. Solutions</a>
### **2.1 Solution 1**   

- **[Step 1]** Implement MAML 
    - **[Problem 1]** Modification of the initial model to deal with text data

- **[Step 2]** Implement 

### **2.2 Solution 2** 
- **[Step 1]** Replace the layers of convolution network with a simple Embedding + LSTM layer for text

### **2.3 Solution 3**
TBA

---
## <a id="experiment">3. Experiment </a>
### **3.1 Experiment Goal**   

### **3.2 Experiment Plan** 
a. Dataset:
b. Baseline Approaches:
d. Evaluation Metrics:

### **3.3 Experiment Result**
TBA

---
## <a id="comment">4. Comment</a>
### **4.1 Abstract**


### **4.2 Related works**


### **4.3 Key pictures**

**Metric-based Few-shot Learning** (using triplet loss)

The basic idea of triplet loss: Given three samples - anchor (current sample), positive (sample of the same class), and negative 
(sample of a different class). The goal of learning is to shorten the distance between anchor and positive and further the distant 
from anchor and negative.

![Fig. 1: Triplet Loss Idea](./figures/triplet_loss_idea.png)
<p align="center">Figure 1: Basic idea of triplet loss. Source: Schroff et al., 2015 [12]</p>

The loss function is described below:

![Fig. 2: Triplet Loss Function](./figures/triplet_loss_func.png)
<p align="center">Figure 2: Triplet Loss Function. Source: Schroff et al., 2015 [12]</p>

**Model-Agnostic Meta-learning** (MAML)

![Fig. 3: MAML Loss Optimization](./figures/MAML_intuition.png)
<p align="center">Figure 3: MAML Loss Optimization. Source: Finn et al., 2018 [1]</p>

MAML Algorithm (update of parameters \theta)

![Fig. 4: MAML Loss Update](./figures/MAML_algo.png)
<p align="center">Figure 4: MAML Algorithm. Source: Finn et al., 2018 [1]</p>


### **4.4 Visual output**
TBA

### **4.5 Discussion**  
TBA

### **4.6 References**
<a id="yin17">[3]</a> Chengxiang Yin, Jian Tang, Zhiyuan Xu, Yanzhi Wang. _Adversarial Meta-Learning_. arXiv:1806.03316v2. 27 Jun 2019

<a id="zhang18">[4]</a> Ruixiang Zhang, Tong Che, Zoubin Grahahramani, Yoshua Bengio, Yangqiu Song. _MetaGAN: An Adversarial Approach to Few-Shot Learning_. In Proceedings of the 32nd Conference on Neural Information Processing Systems (NIPS 2018), Montréal, Canada.

---
## <a id="qna">Questions and Answers</a>


