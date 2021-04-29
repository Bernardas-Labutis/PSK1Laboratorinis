package lt.vu.decorators;

import lt.vu.usecases.IUpdateGunDetails;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

@Decorator
public class UpdateGunDetailsDecorator implements IUpdateGunDetails {
    @Inject
    @Delegate
    @Any
    IUpdateGunDetails updateGunDetails;


    @Override
    public String updateGunName() throws InterruptedException {
        String result = updateGunDetails.updateGunName();
        return result + "&decorated=yes";
    }
}
