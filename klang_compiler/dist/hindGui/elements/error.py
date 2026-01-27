from __future__ import annotations

from hindGui import ELEM_TYPE_ERROR
from hindGui.elements.base import Element


class ErrorElement(Element):
    """
    A "dummy Element" that is returned when there are error conditions, like trying to find an element that's invalid
    """

    def __init__(self, event=None, metadata=None):
        """
        :param event: Used with window.find_element and with return values to uniquely identify this element
        :type event:
        """
        self.Key = event

        super().__init__(ELEM_TYPE_ERROR, event=event, metadata=metadata)

    def change(self, silent_on_error=True, *args, **kwargs):
        """
        Change method for the Error Element, an element that should not be directly used by developer

        :param silent_on_error: if False, then a Popup window will be shown
        :type silent_on_error:  (bool)
        :param *args:           meant to "soak up" any normal parameters passed in
        :type *args:            (Any)
        :param **kwargs:        meant to "soak up" any keyword parameters that were passed in
        :type **kwargs:         (Any)
        :return:                returns 'self' so call can be chained
        :rtype:                 (ErrorElement)
        """
        print('** Your change is being ignored because you supplied a bad event earlier **')
        return self

    def get(self):
        """
        One of the method names found in other Elements. Used here to return an error string in case it's called

        :return: A warning text string.
        :rtype:  (str)
        """
        return 'This is NOT a valid Element!\nSTOP trying to do things with it or I will have to crash at some point!'

    Get = get
    Change = change
