import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import javax.swing.*;

class Panel extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int x = 990;
        for (int h : Main.list) {
            x -= 5;
            g.fillRect(x, 0, 5, h * 3);
        }
    }

    Panel() {
        this.setSize(1006, 636);
        this.setLocation(0, 0);

    }
}

class Frame extends JFrame implements ActionListener {
    Panel panel;
    JButton reset = new JButton();

    void next() {
        reset.doClick();
    }

    void end_this() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        this.dispose();
    }

    Frame(String title) {
        this.setTitle(title);
        this.setResizable(false);
        this.setLocation(200, 50);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1006, 636);
        this.setLayout(null);

        reset.addActionListener(this);

        panel = new Panel();

        this.add(panel);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == reset) {
            this.remove(panel);
            panel = new Panel();
            this.add(panel);
            SwingUtilities.updateComponentTreeUI(this);
        }
    }
}

class Main {
    static int list[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 124, 125, 126, 127, 128, 129, 130, 131, 132, 133, 134, 135, 136, 137, 138, 139, 140, 141, 142, 143, 144, 145, 146, 147, 148, 149, 150, 151, 152, 153, 154, 155, 156, 157, 158, 159, 160, 161, 162, 163, 164, 165, 166, 167, 168, 169, 170, 171, 172, 173, 174, 175, 176, 177, 178, 179, 180, 181, 182, 183, 184, 185, 186, 187, 188, 189, 190, 191, 192, 193, 194, 195, 196, 197, 198, 199, 200 };

    static void shuffle(int arr[], int arr_len) {
        Random random = new Random();
        for (int i = arr_len - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public static void main(String[] args) {
        shuffle(list, list.length);
        Algorithms.bubble_sort(list, list.length);
        shuffle(list, list.length);
        Algorithms.insertion_sort(list, list.length);
        shuffle(list, list.length);
        Algorithms.selection_sort(list, list.length);
        shuffle(list, list.length);
        Algorithms.quick_sort(list, list.length);
        shuffle(list, list.length);
        Algorithms.merge_sort(list, list.length);
        shuffle(list, list.length);
        Algorithms.radix_sort(list, list.length);
        shuffle(list, list.length);
        Algorithms.heap_sort(list, list.length);
        shuffle(list, list.length);
        Algorithms.shell_sort(list, list.length);
    }
}

class Algorithms {
    static void bubble_sort(int arr[], int arr_len) {
        Frame f = new Frame("bubble sort");
        for (int i = 0; i < (arr_len - 1); i++) {
            boolean swapped = false;
            for (int j = 0; j < (arr_len - i - 1); j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
            f.next();
        }
        f.end_this();
    }

    static void insertion_sort(int arr[], int arr_len) {
        Frame f = new Frame("insertion sort");
        for (int step = 1; step < arr_len; step++) {
            int key = arr[step];
            int j = step - 1;
            while (j >= 0 && key < arr[j]) {
                arr[j + 1] = arr[j];
                j -= 1;
            }
            arr[j + 1] = key;
            f.next();
        }
        f.end_this();
    }

    static void selection_sort(int arr[], int arr_len) {
        Frame f = new Frame("selection sort");
        for (int step = 0; step < arr_len - 1; step++) {
            int min_idx = step;
            for (int i = step + 1; i < arr_len; i++) {
                if (arr[i] < arr[min_idx]) {
                    min_idx = i;
                }
            }
            int temp = arr[step];
            arr[step] = arr[min_idx];
            arr[min_idx] = temp;
            f.next();
        }
        f.end_this();
    }

    static void quickSort(int arr[], int low, int high, Frame f) {
        while (low < high) {
            int pivot = arr[high];
            int i = (low - 1);
            for (int j = low; j < high; j++) {
                if (arr[j] <= pivot) {
                    i += 1;
                    if (arr[i] != arr[j]) {
                        int temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                        f.next();
                    }
                }
            }
            int temp = arr[i + 1];
            arr[i + 1] = arr[high];
            arr[high] = temp;
            if ((i + 1) - low < high - (i + 1)) {
                quickSort(arr, low, (i + 1) - 1, f);
                low = (i + 1) + 1;
            } else {
                quickSort(arr, (i + 1) + 1, high, f);
                high = i;
            }
        }
    }

    static void quick_sort(int arr[], int arr_len) {
        Frame f = new Frame("quick sort");
        quickSort(arr, 0, arr_len - 1, f);
        f.end_this();
    }

    static void merge(int arr[], int start, int mid, int end, Frame f) {
        int start2 = mid + 1;
        if (arr[mid] <= arr[start2]) {
            return;
        }
        while (start <= mid && start2 <= end) {
            if (arr[start] <= arr[start2]) {
                start++;
            } else {
                int value = arr[start2];
                int index = start2;
                while (index != start) {
                    arr[index] = arr[index - 1];
                    index--;
                    // f.next();
                }
                arr[start] = value;
                f.next();
                start++;
                mid++;
                start2++;
            }
        }
    }

    static void mergeSort(int arr[], int l, int r, Frame f) {
        if (l < r) {
            int m = l + (r - l) / 2;
            mergeSort(arr, l, m, f);
            mergeSort(arr, m + 1, r, f);
            if (arr[m] > arr[m + 1]) {
                merge(arr, l, m, r, f);
            }
        }
    }

    static void merge_sort(int arr[], int arr_len) {
        Frame f = new Frame("merge sort");
        mergeSort(arr, 0, arr_len - 1, f);
        f.end_this();
    }

    static void countingSort(int array[], int size, int place, Frame f) {
        int[] output = new int[size + 1];
        int max = getMax(array, size);
        int[] count = new int[max + 1];
        for (int i = 0; i < max; ++i) {
            count[i] = 0;
        }
        for (int i = 0; i < size; i++) {
            count[(array[i] / place) % 10]++;
        }
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }
        for (int i = size - 1; i >= 0; i--) {
            output[count[(array[i] / place) % 10] - 1] = array[i];
            count[(array[i] / place) % 10]--;
        }
        for (int i = 0; i < size; i++) {
            array[i] = output[i];
            f.next();
        }
    }

    static int getMax(int array[], int n) {
        int max = array[0];
        for (int i = 1; i < n; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    static void radix_sort(int arr[], int arr_len) {
        Frame f = new Frame("radix sort");
        int max = getMax(arr, arr_len);
        for (int place = 1; max / place > 0; place *= 10) {
            countingSort(arr, arr_len, place, f);
        }
        f.end_this();
    }

    static void heapify(int arr[], int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if (l < n && arr[l] > arr[largest]) {
            largest = l;
        }
        if (r < n && arr[r] > arr[largest]) {
            largest = r;
        }
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            heapify(arr, n, largest);
        }
    }

    static void heap_sort(int arr[], int arr_len) {
        Frame f = new Frame("heap sort");
        for (int i = arr_len / 2 - 1; i >= 0; i--) {
            heapify(arr, arr_len, i);
        }
        for (int i = arr_len - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
            f.next();
        }
        f.end_this();
    }

    static void shell_sort(int arr[], int arr_len) {
        Frame f = new Frame("shell sort");
        for (int interval = arr_len / 2; interval > 0; interval /= 2) {
            for (int i = interval; i < arr_len; i++) {
                int temp = arr[i];
                int j;
                for (j = i; j >= interval && arr[j - interval] > temp; j -= interval) {
                    arr[j] = arr[j - interval];
                }
                if (arr[j] != temp) {
                    arr[j] = temp;
                    f.next();
                }
            }
            f.next();
        }
        f.end_this();
    }
}
