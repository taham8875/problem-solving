class ListNode {
  val: number;
  next: ListNode | null;
  constructor(val?: number, next?: ListNode | null) {
    this.val = val === undefined ? 0 : val;
    this.next = next === undefined ? null : next;
  }
}

function mergeNodes(head: ListNode | null): ListNode | null {
  let currentNodeOfTheInput: ListNode | null = head?.next ?? null; // just ignore the first node which will be always zero
  let headOfOutputNode: ListNode = new ListNode();
  let currentNodeOfTheOutput: ListNode | null = null;

  let sumOfMergedNodes = 0;

  if (currentNodeOfTheInput === null) return null;

  while (currentNodeOfTheInput != null) {
    if (currentNodeOfTheInput.val == 0) {
      if (currentNodeOfTheOutput === null) {
        currentNodeOfTheOutput = headOfOutputNode;
      } else {
        currentNodeOfTheOutput.next = new ListNode();
        currentNodeOfTheOutput = currentNodeOfTheOutput.next;
      }
      currentNodeOfTheOutput.val = sumOfMergedNodes;
      sumOfMergedNodes = 0;
    }

    sumOfMergedNodes += currentNodeOfTheInput.val;

    currentNodeOfTheInput = currentNodeOfTheInput?.next;
  }

  return headOfOutputNode;
}
