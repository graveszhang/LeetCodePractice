class Solution:
    def intToRoman(self, num: int) -> str:
        thousands=["","M","MM","MMM"]
        hundreds=["","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"]
        tens=["","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"]
        ones=["","I","II","III","IV","V","VI","VII","VIII","IX"]
        
        thi = int(num / 1000)
        hi = int((num - thi * 1000)/100)
        tei = int((num - thi*1000 - hi*100)/10)
        oi = int(num - thi*1000 - hi*100 - tei *10)
        
        thousand=thousands[thi] 
        hundred=hundreds[hi]
        ten=tens[tei]
        one=ones[oi]
        s=thousand+hundred+ten+one
        return s
