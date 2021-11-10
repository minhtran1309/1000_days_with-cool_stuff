class TreeNode:
	def __init__(self, val=0, left=None, right=None):
		self.val = val
		self.left = left
		self.right = right
class Solution:
	def dfs(self, root: Optional[TreeNode]) -> List[str]:
		if root:
			if root.left:
				self.dfs(root.left)
			if root.right:
				self.dfs(root.right)
			return root.val

var depthFirstTraverse = function(node) {
    visit(node, "PRE_ORDER");

    if (node.left) {
        depthFirstTraverse(node.left);
    }

    visit(node, "IN_ORDER");

    if (node.right) {
        depthFirstTraverse(node.right);
    }
    
    visit(node, "POST_ORDER");
};
def bfs(root):
	seen = []
	queue = []
	while queue:
		# visited this node 
		node = queue.pop(0)
		seen.append(node.val)
		# Adding its neighbour to the queue
		if node.left is not None:
			queue.append(node.left)
		if node.right is not None:
			queue.append(node.right)
	return seen

