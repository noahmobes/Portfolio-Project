// Noah Moberly
// nmoberly@cnm.edu
// Driver.cpp

#include "Functions.h"
#include "Powerball.h"

using namespace std;

int main() {
	Powerball pw;

	bool playing = true;

	WriteHeader();
	pw.SetPlayersName(AskName());

	do {
		// Player numbers
		int playerPow = 0;
		//int playerList[5];
		array<int, 5> playerList = {};
		int* p_playerPow = &playerPow;
		AskPlayerNum(playerList, p_playerPow);
		pw.SetPlayerNumbers(playerList, playerPow);

		cout << pw.DisplayNumbers() << endl;
		cout << pw.DisplayResults() << endl;

		char again = ' ';

		while (again != 'y' && again != 'n') {
			cout << endl << "Would you like to play again? (y/n)" << endl;
			cin >> again;
		}
		if (again == 'n') {
			playing = false;
		}
	} while (playing);

	return 0;
}