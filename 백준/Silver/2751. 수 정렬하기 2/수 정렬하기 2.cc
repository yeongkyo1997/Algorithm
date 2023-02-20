#include <iostream>

#include <algorithm>

using namespace std;

 

const int MAX = 1000000;

 

int N;

int arr[MAX];

int tempArr[MAX];

 

/*

void partition(int low, int high, int &pivotpoint)

{

        int pivotItem = arr[low];

        int idx = low;

 

        for(int i=low + 1; i <= high; i++)

                 if (arr[i] < pivotItem) //pivotItem보다 arr[i]가 클 경우

                 {

                         idx++;

                         swap(arr[i], arr[idx]);

                 }

        pivotpoint = idx;

        swap(arr[low], arr[pivotpoint]); //정렬했을 때 위치해야하는 곳으로 이동

}

 

void quickSort(int low, int high)

{

        int pivotpoint;

 

        if (high > low)

        {

                 partition(low, high, pivotpoint);

                 quickSort(low, pivotpoint - 1);

                 quickSort(pivotpoint + 1, high);

        }

}

*/

 

/*

void quickSort(int low, int high)

{

        int pivot = low;

        int idx = low;

       

        if (high > low)

        {

                 for (int i = low + 1; i <= high; i++)

                         if (arr[i] < arr[pivot])

                         {

                                 idx++;

                                 swap(arr[idx], arr[i]);

                         }

 

                 swap(arr[low], arr[idx]);

                 pivot = idx;

 

                 quickSort(low, pivot - 1);

                 quickSort(pivot + 1, high);

        }

}

*/

 

void merge(int low, int mid, int high)

{

        int i = low, j = mid + 1, k = low;

 

        while (i <= mid && j <= high)

        {

                 if (arr[i] < arr[j])

                         tempArr[k] = arr[i++];

                 else

                         tempArr[k] = arr[j++];

                 k++;

        }

       

        if (i > mid)

                 for (int idx = j; idx <= high; idx++)

                         tempArr[k++] = arr[idx];

        else

                 for (int idx = i; idx <= mid; idx++)

                         tempArr[k++] = arr[idx];

 

        for (int idx = low; idx <= high; idx++)

                 arr[idx] = tempArr[idx];

}

 

void mergeSort(int low, int high)

{

        if (high>low)

        {

                 int mid = (low + high) / 2;

                 mergeSort(low, mid);

                 mergeSort(mid + 1, high);

                 merge(low, mid, high);

        }

}

 

int main(void)

{

        cin >> N;

 

        for (int i = 0; i < N; i++)

                 //cin >> arr[i];

                 scanf("%d", &arr[i]);

 

        //quickSort(0, N - 1);

        mergeSort(0, N - 1);

 

        for (int i = 0; i < N; i++)

                 //cout << arr[i] << endl;

                 printf("%d\n", arr[i]);

 

        return 0;

}