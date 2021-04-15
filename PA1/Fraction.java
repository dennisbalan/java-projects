class Fraction{
        //class consists of 2 ints, one numerator(int num), one deominator(int denom). Those two variables create the Fraction
        int num,denom;
        //constructor
        //this constructor is used to create a fraction version of a whole number
        public Fraction(){
                num = 1;
                denom = 1;
        }
        public Fraction(int num2)
        {       //mumerator is set to num,denominator is set to 1
                num = num2;
                denom = 1;
        }
        //this constructor is used to cr/eate fractions that aren't whole
        public Fraction(int num2,int denom2)
        {       //Numerator is set to num, denominator is set to denom;
                num = num2;
                denom = denom2;
        }
        //multiplication function. multiplys numerator 1 by numerator 2, and multiplies denominator 1 by denominator 2; value is saved in new Fraction called result and returned
        public Fraction mul(Fraction n){
                //create new fraction object result
                Fraction result = new Fraction(1);
                //denom of result is set to the product of n.denom and (my).denom
                result.denom = denom * n.denom;
                //numerator is set to the product of the numerators
                result.num = num * n.num;
		//reduce the resilt
		result = result.reduce();
		//return the result
                return(result);
        }
        //Division function. multiplies first (my) numerator by 2nd (n) denominator and does the same for the first denominator vise versa.
        public Fraction div(Fraction n){
                //new Fraction named result, this is the return value
                Fraction result = new Fraction();
                //result.num is my num multiplied by n denom
                result.num = num * n.denom;
                //result.denom is my denom multiplied by n num
                result.denom = denom * n.num;
                //retur result
                return(result);
        }
        //method converts fraction to double
        public double toDouble(){
                //double num_d and denom_d are converted ints from the Fraction class//
                double num_d = num;
                double denom_d = denom;
                //result is the num in double form divided by the denominator in double form//
                double result = num_d/denom_d;
                //return the result//
                return(result);
        }
        //create a string version of a Fraction object, and format if needed
        public String toString(){
                //if both num and denom are negative, convert all to positive
                if(denom < 0 && num < 0){
                        //create new vars u_denom and u_num
                        int u_denom = -denom;
                        int u_num = -num;
                        //create theString result
                        String result = (u_num + "/" + u_denom);
                        //return it
                        return(result);
                }
                //if denom is negative, invert both the num and denom for formatting
                else if(denom < 0){
                        //U-denom and u_num are onverted version of denom and num respectively
                        int u_denom = -denom;
			 int u_num = -num;
                        //create the String
                        String result = (u_num+ "/" + u_denom);
                        //return the string result
                        return(result);
                }
                else{
                        //just combine the strings anf return the value
                        String result = (num + "/" + denom);
                        return(result);
                }
        }

        //method returns Fraction value. adds Fractions by multiplyiing the denoms of (my) denom and n.denom and cross multiplies and adds the numerators by multiplying each numerator with the opposite denom
        public Fraction add(Fraction n){
		//create new Fraction
                Fraction result = new Fraction();
		//cross multiply the numerators
                result.num = num * n.denom + n.num * denom;
		//nultiply the denominators
                result.denom = denom * n.denom;
		//reduce the fraction
		result = result.reduce();
		//return the result
                return(result);
        }
	//method returns Fraction value adds Fractions by multiplyiing the denoms of (my) denom and n.denom and cross multiplies and subtracts the numerators by multiplying each numerator with the opposite denom
	public Fraction sub(Fraction n){
		//create new Fraction object
                Fraction result = new Fraction();
		//cross multiply and subtract the numerators
                result.num = num * n.denom - n.num * denom;
		//multiply the donminators
                result.denom = denom * n.denom;
		//reduce
		result = result.reduce();
		//return the result
                return(result);
        }
	//returns interger value by setting return value to numerator(my num)
        public int getNum(){
		//set int a to num and return a
                int a = num;
                return(a);
        }
	//returns interger value by setting return value to denominator(my num)
        public int getDenom(){
		//set int a to num and return a
                int a = denom;
                return(a);
        }
	private Fraction reduce(){
		int input1 = num;
		int num_2 = input1;
		int input2  = denom;
		int denom_2 = input2;
		int rem;
		int gcd;
		int answer;
		while(1 == 1){
			int ecd = input1/input2;
			rem = input1 % input2;
			System.out.println(input1 + " = " + input2 + "*" + ecd + " plus " + rem);
			//remainder error
			if(rem == 0 && input2 != 0){
				gcd = input2;
				int a,b;
                		a = num_2/gcd;
                		b = denom_2/gcd;
                		Fraction result = new Fraction(a,b);
                		return(result);
			}
			input1 = input2;
			input2 = rem;
		}
	}
		
}


