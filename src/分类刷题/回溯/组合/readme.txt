https://leetcode-cn.com/problems/combinations/

排列问题考虑顺序，每次需要从头开始找，因此要用used数组标记之前是否使用过
组合问题不考虑顺序。只需要从当前位置向后找，不需要数组标记
