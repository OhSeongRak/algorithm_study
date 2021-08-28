inc_s=[]
    n=len(heights)
    ans=[0]*n
    
    for indx in range(n-1,-1,-1):
        total=0
    
        while inc_s and heights[indx]>inc_s[-1]:
            inc_s.pop()
            total+=1
        
        if inc_s:
            total+=1
        
        inc_s.append(heights[indx])
        ans[indx]=total
    
    return ans
