#define DOCTEST_CONFIG_IMPLEMENT_WITH_MAIN
#include <vector>
#include <iostream>
#include <doctest.h>
#include "AreAnagrams.cpp"

class AnagramTestFixture{
protected:
	AreAnagrams obj;

	std::string a = "racecar";
	std::string b = "carrace";
	std::string c = "jar";
	std::string d = "jam";
};
TEST_CASE_FIXTURE(AnagramTestFixture, "AreAnagrams using Default method") {
	CHECK(obj.areAnagrams(a, b) == true);
	CHECK(obj.areAnagrams(c, d) == false);
}

TEST_CASE_FIXTURE(AnagramTestFixture, "AreAnagrams using Array method") {
	CHECK(obj.areAnagramsArray(a, b) == true);
	CHECK(obj.areAnagramsArray(c, d) == false);
}

TEST_CASE_FIXTURE(AnagramTestFixture, "AreAnagrams using Brute method") {
	CHECK(obj.areAnagramsBrute(a, b) == true);
	CHECK(obj.areAnagramsBrute(c, d) == false);
}

