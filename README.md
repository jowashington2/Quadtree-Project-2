# Quadtree-Project-2
Programming Languages 

# Quadtree Project

## Overview
This project implements a **Quadtree data structure** in Java. The objective is to efficiently manage and query two-dimensional rectangular data using object-oriented programming concepts like inheritance, polymorphism, and encapsulation. This project showcases the power of hierarchical data structures in solving spatial computing challenges.

---

## Problem Statement
Managing a large set of rectangular data in a two-dimensional space poses several challenges:
1. **Inefficiency with linear structures**: Operations like insertion, search, and deletion become slow as the dataset grows.
2. **Query complexity**: Without an efficient data structure, determining relationships between rectangles (e.g., overlap, containment) requires high computational effort.
3. **Scalability**: A lack of hierarchical organization makes handling large datasets infeasible.

---

## Findings
Through research and testing, the following conclusions were drawn:
1. A **Quadtree** is a hierarchical data structure that recursively divides a 2D space into four regions (quadrants).
2. **Leaf nodes** store up to a limited number of rectangles, ensuring manageable data loads in each region.
3. By narrowing operations to specific quadrants, the Quadtree significantly improves the efficiency of spatial operations compared to linear lists.

---

## Solution
To address the problem, a **Quadtree data structure** was developed with the following key features:

### Key Components
1. **Inheritance and Polymorphism**:
   - A base `Node` class with two derived classes:
     - `LeafNode`: Stores up to 5 rectangles before splitting.
     - `InternalNode`: Manages child nodes (quadrants) upon splitting.

2. **Operations**:
   - **Insert**: Adds a rectangle to the appropriate node or quadrant.
   - **Find**: Retrieves a rectangle based on its bottom-left corner coordinates.
   - **Delete**: Removes a rectangle and consolidates nodes if the structure becomes underutilized.
   - **Update**: Modifies the dimensions of an existing rectangle.
   - **Dump**: Prints the entire Quadtree structure in a readable format.

3. **Scalability**:
   - Dynamically splits nodes when the rectangle limit is exceeded.
   - Limits operations to the relevant quadrant, reducing computation time.

---

## How to Run
### Prerequisites
- **Java 11+**
- **Maven** for dependency management
- **Git** for version control

