// Noah Moberly
// nmoberly@cnm.edu
// Powerball.cpp

#include "Powerball.h"
#include <sstream>

using namespace std;

// Constructors
Powerball::Powerball() {}

// Methods
// Public
void Powerball::SetPlayersName(string n) {
	player = n;
};

//void Powerball::SetPlayerNumbers(int num[], int red) {
void Powerball::SetPlayerNumbers(array<int, SIZE> num, int red) {
	Sort(num);
	GenerateGameNumbers();
	CheckResults();

	playerWhite = num;
	playerRed = red;
};

string Powerball::DisplayNumbers() {
	stringstream sstr;

	sstr << endl;
	sstr << player << "'s white numbers: ";
	for (int i = 0; i < 5; i++) {
		sstr << playerWhite[i] << " ";
	}

	sstr << endl;
	sstr << player << "'s red number: " << playerRed << endl;

	sstr << endl;
	sstr << "The computer's white numbers: ";
	for (int i = 0; i < 5; i++) {
		sstr <<  gameWhite[i] << " ";
	}

	sstr << endl;
	sstr << "The computer's red number: " << gameRed << endl;

	return sstr.str();
};

string Powerball::DisplayResults() {
	return result;
};

// Private

//void Powerball::Sort(array<int, SIZE>& n) {
void Powerball::Sort(array<int, SIZE>& n) {
    for (int i = 0; i < 5; i++) {
        for (int j = 0; j < 4; j++) {
            if (n[j] > n[j + 1])
            {
                int item;
                item = n[j + 1];
                n[j + 1] = n[j];
                n[j] = item;
            }
        }
    }
};

void Powerball::GenerateGameNumbers() {
	srand(time(0));

	bool check[56];

	// Fill check array with falses
	for (int i = 0; i < 55; i++) {
		check[i] = false;
	}

	for (int i = 0; i < 5; i) {
		int random = rand() % 55 + 1;

		if (!check[random]) {
			check[random] = true;
			gameWhite[i] = random;
			i += 1;
		}
	}

	Sort(gameWhite);

	gameRed = rand() % 42 + 1;
};

void Powerball::CheckResults() {
	int matching = 0;
	bool red = playerRed == gameRed ? true : false;
	string str = "You didn't win anything :(";

	for (int i = 0; i < 5; i++) {
		for (int j = 0; j < 5; j++) {
			if (gameWhite[i] == playerWhite[j]) {
				matching += 1;
			}
		}
	}

	if (matching == 5 && red) {
		str = "You won $23,000,000!";
	}
	else if (matching == 5) {
		str = "You won $1,000,000!";
	}
	else if (matching == 4 && red) {
		str = "You won $10,000!";
	}
	else if (matching == 4) {
		str = "You won $100!";
	}
	else if (matching == 3 && red) {
		str = "You won $100!";
	}
	else if (matching == 3) {
		str = "You won $7!";
	}
	else if (matching == 2 && red) {
		str = "You won $7!";
	}
	else if (matching == 1 && red) {
		str = "You won $4!";
	}
	else if (matching == 0 && red) {
		str = "You won $4!";
	}

	result = str;
};