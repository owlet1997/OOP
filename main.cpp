#include <iostream>
#include <vector>
using namespace std;
class Money
{
private:
    int cash;
    string valute;
    bool type;
public:
    Money(int c, string v, bool t)
    {
        this->cash = c;
        this->valute = v;
        this->type = t;
    }
    int getCash()
    {
        return this->cash;
    }
    string getValute()
    {
        return this->valute;
    }
    bool getType()
    {
        return this->type;
    }
    void print()
    {

        cout<<"How much?\t"<<this->getCash()<<endl;
        cout<<"What valute?\t"<<this->getValute()<<endl;
        cout<<"What type?\t";
        if (this->getType()) cout<<"coin"<<endl;
        else cout<<"banknote"<<endl;
    }

};
int main() {
    vector<Money> takeMyMoney;
    cout << "Hello, World!" << endl;
    Money m1 = Money(34, "dollar", true);
    Money m2 = Money(35, "rubl", false);
    takeMyMoney.push_back(m1);
    takeMyMoney.push_back(m2);
    for (auto m: takeMyMoney)
        m.print();

    return 0;
}
