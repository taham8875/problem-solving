type F = (...args: number[]) => void;

function debounce(fn: F, t: number): F {
  let outerArgs: number[] = [];
  let ref: ReturnType<typeof setTimeout> | null = null;
  return function (...args) {
    outerArgs = args;
    if (ref) {
      clearTimeout(ref);
    }
    ref = setTimeout(() => {
      fn(...outerArgs);
      ref = null;
    }, t);
  };
}

/**
 * const log = debounce(console.log, 100);
 * log('Hello'); // cancelled
 * log('Hello'); // cancelled
 * log('Hello'); // Logged at t=100ms
 */
