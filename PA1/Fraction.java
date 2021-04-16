//Dennis Balan, 4/15/2021, CSE 223. The Fraction class represents fractions as an object in Java and uses 2 internal variables = num and denom, which represent the numerator and the denominator of the function respecively. It performs basic mathematical operations (multiplication, dvision, addisition and subtraction) and reduces them to the simplest form. It also converts Fractions to string and double formats and can return the num and denom values
//Important: (my) in comments refers to the object the method is being applied to
class Fraction{
        //class consists of 2 ints, one numerator(int num), one deominator(int denom). Those two variables create the Fraction
        int num,denom;
        //constructor
        //this constructor is used to create a fraction version of a 1. It is default
        public Fraction(){
                num = 1;
                denom = 1;
        }
	//Constructor used to create a whole number
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
		//reduce
		//this.reduce();
        }
        //multiplication function. multiplys numerator 1 by numerator 2, and multiplies denominator 1 by denominator 2; value is saved in new Fraction called result, simplifoed and returned as a Fractiom. Also returns a NaN (1/0) if denom of any number is 0
        public Fraction mul(Fraction n){
                //create new fraction object result
                Fraction result = new Fraction(1);
		//Nan return,creates Fraction 1/0 and returns it
		if(denom == 0 || n.denom == 0){
			result.num = 1;
			result.denom = 0;
			return(result);
		}
                //denom of result is set to the product of n.denom and (my).denom
                result.denom = denom * n.denom;
                //numerator is set to the product of the numerators
                result.num = num * n.num;
		//reduce the resilt
		result = result.reduce();
		//return the result
                return(result);
        }
        //Division function. multiplies first (my) numerator by 2nd (n) denominator and does the same for the first denominator vise versa. Simplifies and returned as a Fraction Object. If denom of any number is 0, returns NaN (1/0)
        public Fraction div(Fraction n){
                //new Fraction named result, this is the return value
                Fraction result = new Fraction();
		//Nan return. if any denom = 0, set Fraction to 1/0 and return
		if(denom == 0 || n.denom == 0){
                        result.num = 1;
                        result.denom = 0;
                        return(result);
                }
                //result.num is my num multiplied by n denom
                result.num = num * n.denom;
                //result.denom is my denom multiplied by n num
                result.denom = denom * n.num;
		//reduce
		result = result.reduce();
                //retur result
                return(result);
        }
        //method converts fraction to double and returns double. If denominator is 0, returns Double NaN
        public double toDouble(){
                //double num_d and denom_d are converted ints from the Fraction class//
                double num_d = num;
                double denom_d = denom;
		//Nan check, if denom 0 returm a double.Nan
		if(denom_d == 0){
			return(Double.NaN);
		}
                //result is the num in double form divided by the denominator in double form//
                double result = num_d/denom_d;
                //return the result//
                return(result);
        }
        //create a string version of a Fraction object, and format if needed and returns a string. If Denominator is 0, returns "NaN"
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
		//if denom is 0,return string NaN
		else if(denom == 0){
			return("NaN");
		}
                else{
                        //just combine the strings anf return the value
                        String result = (num + "/" + denom);
                        return(result);
                }
        }

        //method returns Fraction value. adds Fractions by multiplyiing the denoms of (my) denom and n.denom and cross multiplies and adds the numerators by multiplying each numerator with the opposite denominators. Simplifies and returns Fraction Value. If denominator of any number is 0 returns a 1/0 (NaN)
        public Fraction add(Fraction n){
		//create new Fraction
                Fraction result = new Fraction();
		//Nan return. if any denom = 0, set Fraction to 1/0 and return
                if(denom == 0 || n.denom == 0){
                        result.num = 1;
                        result.denom = 0;
                        return(result);
                }
		//cross multiply the numerators
                result.num = num * n.denom + n.num * denom;
		//nultiply the denominators
                result.denom = denom * n.denom;
		//reduce the fraction
		result = result.reduce();
		//return the result
                return(result);
        }
	//method returns Fraction value adds Fractions by multiplyiing the denoms of (my) denom and n.denom and cross multiplies and subtracts the numerators by multiplying each numerator with the opposite denom.Simplifies the return value and returns a 1/0(NaN if any denominator is 0
	public Fraction sub(Fraction n){
		//create new Fraction object
                Fraction result = new Fraction();
		//Nan return. if any denom = 0, set Fraction to 1/0 and return
                if(denom == 0 || n.denom == 0){
                        result.num = 1;
                        result.denom = 0;
                        return(result);
                }
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
	//returns a reduced Fraction. reduce a fraction using euclid's algorithm. input1 and input2 are inputs for eculid's algorithm. rem is the remainder. returns a 1/0(Nan) if denom is 0, and returns a 1/0 if num is 0
	private Fraction reduce(){
		//set input1 for eculi's algorithm as the numerator
		int input1 = num;
		//set num_2 to input1
		int num_2 = input1;
		//set input 2 for euclid's algorithm as the denominator
		int input2  = denom;
		//set denom_2 as input2
		int denom_2 = input2;
		//create vars rem (remainder) and gcd (greatest common divisor)
		int rem,gcd;
		//infinite loop
		while(1 == 1){
			//NaN check, returns a 1/0 if denom is 0
			if(input2 == 0){
				Fraction result = new Fraction(1,0);
				return(result);
			}
			//0/1 check, returns 1/0 if num is 0
			if(input1 == 0){
				Fraction result = new Fraction(0,1);
				return(result);
			}
			//divide input1 by input2
			int ecd = input1/input2;
			//find the modulo of input1 and input2
			rem = input1 % input2;
			/*System.out.println(input1 + " = " + input2 + "*" + ecd + " plus " + rem);*/
			//activate if remainder is 0
			if(rem == 0 && input2 != 0){
				//gcd is set to input2
				gcd = input2;
				//create vars a,b (new num and new denom respectively and divide both by the gcd
				int a,b;
                		a = num_2/gcd;
                		b = denom_2/gcd;
				//create new Fraction result using a and b as numerator and deonimators respectively
                		Fraction result = new Fraction(a,b);
				//return result
                		return(result);
			}
			//input1 is resr ro input2
			input1 = input2;
			//input2 is rest to remainder
			input2 = rem;
		}
	}
		
}


