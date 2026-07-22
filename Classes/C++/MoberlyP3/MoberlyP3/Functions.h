// Noah Moberly
// nmoberly@cnm.edu
// Functions.h

#ifndef FUNCTIONS_H
#define FUNCTIONS_H

#include <iostream>
#include <random>
#include <ctime>

using namespace std;

// To write header
void WriteHeader();

// To get the user's name
string AskName();

// To get powerball numbers
void AskPlayerNum(array<int, 5>& num, int* powNum);

#endif