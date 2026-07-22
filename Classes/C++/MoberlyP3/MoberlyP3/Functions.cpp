// Noah Moberly
// nmoberly@cnm.edu
// Functions.cpp

#include "Functions.h"
#include <array>

// To write header
void WriteHeader() {
	cout << "Noah Moberly" << endl;
	cout << "MoberlyP1" << endl;
	cout << "PowerBall" << endl;
	cout << endl;
	cout << "In this game, you give 5 white ball numbers and a red ball number." << endl;
	cout << "If any of the numbers you pick match the ones the computer picks, you can win money!" << endl;
}

// To get the user's name
string AskName() {
	string name = "";

	while (name == "") {
		cout << endl;
		cout << "Please enter your name:" << endl;
		cin >> name;
	}

	return name;
}

// To get powerball numbers
void AskPlayerNum(array<int, 5>& num, int* powNum) {
//void AskPlayerNum(int num[], int* powNum) {
	bool check[56];

	cout << endl;
	cout << "Please enter your numbers: (1 31 14 23 20)" << endl;

	// Fill check array with falses
	for (int i = 0; i < 55; i++) {
		check[i] = false;
	}

	for (int i = 0; i < 5; i) {
		int newNum;
		cin >> newNum;

		if (!check[newNum]) {
			check[newNum] = true;
			num[i] = newNum;
			i += 1;
		}
		else if (check[newNum]) {
			cout << "All numbers must be unique." << endl;
		}
	}

	cout << endl;
	cout << "Please enter your powerball number:" << endl;
	cin >> *powNum;
}