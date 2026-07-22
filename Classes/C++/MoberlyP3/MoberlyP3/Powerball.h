// Noah Moberly
// nmoberly@cnm.edu
// Powerball.h

#pragma once
#ifndef _POWERBALL_H
#define POWERBALL_H

using namespace std;

#include <string>
#include <iostream>
#include <array>

const int SIZE = 5;

class Powerball
{
private:
	string player;
	array<int, SIZE> playerWhite;
	array<int, SIZE> gameWhite;
	int playerRed{};
	int gameRed{};
	string result;
	int total{};
	//default_random_engine engine; ??
	void Sort(array<int, SIZE>& n);
	void GenerateGameNumbers();
	void CheckResults();
public:
	Powerball();
	void SetPlayersName(string n);
	void SetPlayerNumbers(array<int, SIZE> num, int red);
	string DisplayNumbers();
	string DisplayResults();
};

#endif