/* Simple calculator with operator precedence
 * sample output:
 **
 * Enter operation: 20+2*2
 * Result = 24
 **
 * supported operators: + - * /
 *
 * Yusuf (blogkecil.com)
 * 
 */

import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter operation: ");
        String input = sc.next();

        String inputArr[] = new String[input.length()];

        for (int i = 0; i < inputArr.length; i++) {
            inputArr[i] = "";
        }

        int pos = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '+' || input.charAt(i) == '-'
                    || input.charAt(i) == '*' || input.charAt(i) == '/') {
                pos++;
                inputArr[pos] += input.charAt(i) + "";  // convert char to string
                pos++;
            } else {
                inputArr[pos] += input.charAt(i) + "";
            }
        }

        int num1 = 0;
        int num2;
        double result;
        boolean kali = true, bagi = true, tambah = true, kurang = true;

        for (int i = 1; i <= pos; i++) {
            if (kali == true || bagi == true) {
                if (inputArr[i].compareTo("*") == 0) {
                    if (inputArr[i - 1].compareTo("") != 0) {
                        num1 = i - 1;
                    }

                    num2 = i + 1;
                    result = Double.parseDouble(inputArr[num1])
                            * Double.parseDouble(inputArr[num2]);

                    inputArr[num1] = result + "";
                    inputArr[i] = "";
                    inputArr[num2] = "";
                    i++;
                    if (i == pos) {
                        i = 0;
                        kali = false;
                        continue;
                    }
                    i--;
                    continue;
                } else if (bagi == true) {
                    if (inputArr[i].compareTo("/") == 0) {
                        if (inputArr[i - 1].compareTo("") != 0) {
                            num1 = i - 1;
                        }

                        num2 = i + 1;
                        result = Double.parseDouble(inputArr[num1])
                                / Double.parseDouble(inputArr[num2]);

                        inputArr[num1] = result + "";
                        inputArr[i] = "";
                        inputArr[num2] = "";
                        i++;
                        if (i == pos) {
                            i = 0;
                            bagi = false;
                            continue;
                        }
                        i--;
                        continue;
                    }
                    if (i == pos - 1) {
                        i = 0;
                        bagi = false;
                    }
                    continue;
                }
                if (i == pos - 1) {
                    i = 0;
                    kali = false;
                }
                continue;
            }

            if (tambah == true) {
                if (inputArr[i].compareTo("+") == 0) {
                    num1 = i - 1;
                    num2 = i + 1;
                    if (inputArr[num1].compareTo("") == 0) {
                        for (int j = i - 1; j >= 0; j--) {
                            if (inputArr[j].compareTo("") != 0) {
                                num1 = j;
                            }
                        }
                    }
                    if (inputArr[num2].compareTo("") == 0) {
                        for (int j = i + 1; j <= pos; j++) {
                            if (inputArr[j].compareTo("") != 0) {
                                num2 = j;
                            }
                        }
                    }

                    result = Double.parseDouble(inputArr[num1])
                            + Double.parseDouble(inputArr[num2]);
                    inputArr[num1] = result + "";

                    inputArr[i] = "";
                    inputArr[num2] = "";
                    i++;
                    if (i == pos) {
                        i = 0;
                        tambah = false;
                        continue;
                    }
                    i--;
                } else if (kurang == true) {
                    if (inputArr[i].compareTo("-") == 0) {
                        num1 = i - 1;
                        num2 = i + 1;
                        if (inputArr[num1].compareTo("") == 0) {
                            for (int j = i - 1; j >= 0; j--) {
                                if (inputArr[j].compareTo("") != 0) {
                                    num1 = j;
                                }
                            }
                        }
                        if (inputArr[num2].compareTo("") == 0) {
                            for (int j = i + 1; j <= pos; j++) {
                                if (inputArr[j].compareTo("") != 0) {
                                    num2 = j;
                                }
                            }
                        }

                        result = Double.parseDouble(inputArr[num1])
                                - Double.parseDouble(inputArr[num2]);
                        inputArr[num1] = result + "";

                        inputArr[i] = "";
                        inputArr[num2] = "";
                        i++;
                        if (i == pos) {
                            i = 0;
                            kurang = false;
                            continue;
                        }
                        i--;
                    }
                }
            }
        }

        // result is in inputArr[0]
        result = Double.parseDouble(inputArr[0]);

        // if result has no decimal place remove it
        // otherwise keep it
        // ex: 2.0 become 2
        //     2.4 become 2.4 (unchanged)
        if (result - (int) result != 0) {
            System.out.println("Result = " + result);
        } else {
            System.out.println("Result = " + (int) result);
        }
    }
}
