#!/usr/bin/env python

"""
Zipf's Song

A simple solution taking use of Python's heapq for sorting.

Author: Daniel Forslund
		dforsl@kth.se

"""

import sys
import heapq

class Song(object):
	def __init__(self, id, name, play_count):
		self.id, self.name, self.play_count, self.quality = id, name, play_count, play_count*id

def main(argv = None): 
	line = sys.stdin.readline() #Read the first line containing number of songs and expected output number
	n, m = int(line.split()[0]), int(line.split()[1])

	songs = [] #Create our list
	for i in range(n):
		line = sys.stdin.readline().split()

		song = Song((i + 1), line[1], int(line[0])) #Create the song corresponding to the input
		heapq.heappush(songs, (-song.quality, song.id, song)) #Push the song to the minheap, placing at its expected place

	for i in range(m): #Iterate over the expected number of songs to print
		song = heapq.heappop(songs)[2] #Only pick the song itself
		print song.name

if  __name__ == '__main__':
	main()