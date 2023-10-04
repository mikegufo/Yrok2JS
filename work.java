function heapify(arr, n, i) {
    let largest = i; // Инициализировать наибольший элемент как корень
    let left = 2 * i + 1; // left = 2*i + 1
    let right = 2 * i + 2; // right = 2*i + 2
  
    // Если левый дочерний элемент больше корня
    if (left < n && arr[left] > arr[largest]) {
      largest = left;
    }
  
    // Если правый дочерний элемент больше, чем самый большой элемент на данный момент
    if (right < n && arr[right] > arr[largest]) {
      largest = right;
    }
  
    // Если самый большой элемент не корень
    if (largest !== i) {
      [arr[i], arr[largest]] = [arr[largest], arr[i]]; // Обмен значениями
  
      // Рекурсивно применяем функцию к поддереву
      heapify(arr, n, largest);
    }
}
  
function heapSort(arr) {
    const n = arr.length;
  
    // Построение кучи (перегруппировать массив)
    for (let i = Math.floor(n / 2) - 1; i >= 0; i--) {
      heapify(arr, n, i);
    }
  
    // Один за другим извлекаем элементы из кучи
    for (let i = n - 1; i > 0; i--) {
      // Перемещаем текущий корень в конец
      [arr[0], arr[i]] = [arr[i], arr[0]];
  
      // вызываем heapify на уменьшенной куче
      heapify(arr, i, 0);
    }
}
  
// Использование функции сортировки
const arr = [12, 11, 13, 5, 6, 7];
heapSort(arr);
console.log("Отсортированный массив: ", arr);
