#!/bin/sh

sudo hping3 localhost --udp --spoof 198.168.54.36 -p 8765 -c 1 
sudo hping3 localhost --udp --spoof 100.10.200.10 -p 8765 -c 1 
sudo hping3 localhost --udp --spoof 198.168.54.45 -p 8765 -c 1 
sudo hping3 localhost --udp --spoof 198.168.54.150 -p 8765 -c 1 
sudo hping3 localhost --udp --spoof 198.168.0.34 -p 8765 -c 1 
sudo hping3 localhost --udp --spoof 198.168.2.67 -p 8765 -c 1 
sudo hping3 localhost --udp --spoof 198.168.54.36 -p 8765 -c 1 
sudo hping3 localhost --udp --spoof 198.168.54.36 -p 8765 -c 1 
sudo hping3 localhost --udp --spoof 198.168.54.36 -p 8765 -c 1 
sudo hping3 localhost --udp --spoof 198.168.54.36 -p 8765 -c 1 
sudo hping3 localhost --udp --spoof 198.168.54.36 -p 8765 -c 1 
sudo hping3 localhost --udp --spoof 198.168.54.36 -p 8765 -c 1 
