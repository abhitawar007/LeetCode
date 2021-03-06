package algorithms;

public class FirstBadVersion {
	
	public int firstBadVersion(int n) 
    {
        if(n <= 1)
            return n;
        
        int lo = 1, hi = n;
        
        while(lo <= hi)
        {
            int mid = (lo + hi)/2;
            
            if(isBadVersion(mid))
            {
                if(mid == 1 || !isBadVersion(mid - 1))
                    return mid;
                else
                    hi = mid - 1;
            }
            else
                lo = mid+1;
        }
        return -1;
    }
	
	private boolean isBadVersion(int n)
	{
		if(n>=7)
			return true;
		return false;
	}

}
